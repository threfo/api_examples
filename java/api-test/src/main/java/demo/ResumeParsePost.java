package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;

public class ResumeParsePost {
    // 倍罗SAAS简历解析服务地址, 具体请咨询倍罗技术支持团队
    private final static String PARSER_URL = "";
    private final static String CONTENT_TYPE_JSON = "application/json";
    private final static String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    // 倍罗SAAS服务账号权限相关, 具体请咨询倍罗技术支持团队
    private final static String X_API_KEY = "";

    /**
     * */
    private HttpPost getHttpPost() {
        HttpPost httpPost = new HttpPost(PARSER_URL);
        httpPost.setHeader("Content-Type", CONTENT_TYPE_JSON);
        httpPost.setHeader("X-API-Key", X_API_KEY);
        return httpPost;
    }

    /**
     * ContentType = "application/json"
     * by using apache.http.client
     * */
    public HttpEntity sendToParser(String filePath) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createSystem();

        // choose proper HttpPost with correct header
        HttpPost httpPost = getHttpPost();
        
        // Map<> converted to StringEntity for data{}
        Map<String, Object> params = new HashMap<String, Object>();
        String b64Content = getFileBase64Encoded(filePath);
        params.put("content", b64Content);
        params.put("need_avatar", 1);
        String fileName = FilenameUtils.getName(filePath);
        params.put("filename", fileName);
        
        String jsonParams = new GsonBuilder().create().toJson(params, Map.class);
        HttpEntity entity = new StringEntity(jsonParams);
        httpPost.setEntity(entity);

        
        long start = System.currentTimeMillis();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch(IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        int statusCode = response.getStatusLine().getStatusCode(); // HttpStatus.SC_OK=200
        System.out.println(String.format("http response return after <%dms>, with status code is <%d>", end-start, statusCode));

        return response.getEntity();
    }

    private static String getFileBase64Encoded(String filePath) throws IOException {
        InputStream inStream = new FileInputStream(filePath);
        byte[] bytes = IOUtils.toByteArray(inStream);
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * extract response content as JSONObject from HTTP Post response
     * */
    public static void readJsonFromResponse(InputStream inStream) {
        JSONObject resultJson = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    inStream, StandardCharsets.UTF_8), 8 * 1024);
            String line = null;
            StringBuilder entityStrBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                entityStrBuilder.append(line);
            }
            resultJson = convertString2JSONObject(entityStrBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            resultJson = null;
        }

        iterateJsonObject(resultJson);
        return;
    }

    /**
     * convert a JSON string without \" escape replacement to JSONObject via JsonNode
     * */
    private static JSONObject convertString2JSONObject(String jsonStr) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode nodeObj = mapper.readTree(jsonStr);
        if (nodeObj == null) {
            System.out.println("parsed JsonNode is null");
            return null;
        }
        return new JSONObject(nodeObj.toString());
    }

    /**
     * 递归遍历JSONObject
     * */
    private static void iterateJsonObject(JSONObject jsonRoot) {
        Iterator<String> keys = jsonRoot.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            System.out.println(String.format("<key>=%s:", key));               
            if (jsonRoot.get(key) instanceof JSONObject) {
                JSONObject jsonChild = (JSONObject)jsonRoot.get(key);
                iterateJsonObject(jsonChild);
            } else if (jsonRoot.get(key) instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray)jsonRoot.get(key);
                for (int i = 0; i < jsonArray.length(); i++) {
                    if (jsonArray.get(i) instanceof JSONObject) {
                        iterateJsonObject(jsonArray.getJSONObject(i));
                    } else if (jsonArray.get(i) instanceof String){
                        System.out.println(String.format("String is: %s", jsonArray.getString(i)));
                    } else {
                        System.out.println(String.format("%s", jsonArray.get(i).toString()));                       
                    }
                }          
            } else {
                System.out.println(String.format("%s", jsonRoot.get(key).toString()));               
            }
        }
    }

    public void postResumeParserAsJson(String fullPath) throws IOException {
        long start = System.currentTimeMillis();
        HttpEntity respEntity = sendToParser(fullPath);
        long end = System.currentTimeMillis();
        System.out.println(String.format("the resume parse request returns in <%d> ms",  (end-start)));

        readJsonFromResponse(respEntity.getContent());
    }

    /**
     * ContentType = "application/x-www-form-urlencoded"
     * by using hutool.http
     * */
    public void postResumeParserAsForm(String fullPath) throws IOException {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("path", FileUtil.file(fullPath));
        long start = System.currentTimeMillis();
        String result = HttpRequest.post(PARSER_URL)
                .header("X-API-KEY", X_API_KEY)
                .contentType(CONTENT_TYPE_FORM)
                .form(paramMap).execute().body();
        long end = System.currentTimeMillis();
        System.out.println(String.format("the resume parse request returns in <%d> ms",  (end-start)));
        System.out.println(result);
    }

    /**
     * 入口main()函数
    */
    public static void main(String[] args) throws Exception {
        ResumeParsePost parsePost = new ResumeParsePost();

        // 待解析的简历文件全路径, 可在此处给定, 亦可由参数传入
        String cvFullPath = "";
        if (args.length > 0) {
            cvFullPath = args[0];
        }

        boolean reqInJson = true;
        if (reqInJson) {
            System.out.println("POST to Bello Resume Parse service in JSON");
            parsePost.postResumeParserAsJson(cvFullPath);
        } else {
            System.out.println("POST to Bello Resume Parse service in Form");
            parsePost.postResumeParserAsForm(cvFullPath);
        }
    }
}

