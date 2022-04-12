package com.belloai.api.internal;
import java.io.IOException;

import com.belloai.api.BelloClientErrorCode;
import com.belloai.api.BelloClientException;
import com.belloai.api.BelloResourceErrorCode;
import okhttp3.*;

public abstract class GenericOperation {
    private String authorization;

    public GenericOperation() {
        this.authorization = "";
    }

    public GenericOperation(String authorization) {
        this.authorization = authorization;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Response doOperation(String url, String method, RequestBody body) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request.Builder builder = new Request.Builder();
        builder = builder.url(url);
        builder.method(method, body);
        if (!"".equals(authorization)) {
            builder = builder.addHeader("Authorization", authorization);
        }
        Request request = builder.build();
        Response response = client.newCall(request).execute();
        String bodyStr = response.peekBody(Long.MAX_VALUE).string();
        if (response.code() == 405) {
            throw new BelloClientException("Method Not Allowed: " + method, BelloResourceErrorCode.METHOD_NOT_ALLOWED);
        } else if (response.code() == 401) {
            throw new BelloClientException("Unauthorized: " + authorization + ", Response Body:" + bodyStr, BelloResourceErrorCode.ACCESS_DENIED);
        } else if (response.code() == 403) {
            throw new BelloClientException("Forbidden: " + authorization + ", Response Body: " + bodyStr, BelloResourceErrorCode.ACCESS_FORBIDDEN);
        } else if (response.code() == 422) {
            throw new BelloClientException("Unprocessable Entity: " + bodyStr, BelloResourceErrorCode.UNPROCESSABLE_ENTITY);
        } else if (response.code() == 400) {
            throw new BelloClientException("Bad Request: " + bodyStr, BelloClientErrorCode.UNKNOWN);
        } else if (response.code() == 404) {
            throw new BelloClientException("Not Found: " + url + ", Auth: " + authorization, BelloResourceErrorCode.NOT_FOUND);
        }
        return response;
    }
}
