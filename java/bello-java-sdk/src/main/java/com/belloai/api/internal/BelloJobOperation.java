package com.belloai.api.internal;
import com.belloai.api.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BelloJobOperation extends GenericOperation{

    public Response upsertBelloJob(JobRequest jobRequest) throws IOException {
        String endpoint = jobRequest.getEndpoint();
        String url = jobRequest.getUrl();
        String method = jobRequest.getMethod();
        String fullUrl = endpoint + url;
        BelloJob belloJob = jobRequest.getJob();
        Map<String, Object> payload = new HashMap<>();
        payload.put("payload", belloJob);
        MediaType mediaType = MediaType.parse("application/json");
        ObjectMapper mapper = new ObjectMapper();
        RequestBody body = RequestBody.create(mediaType, mapper.writeValueAsString(payload));
        return doOperation(fullUrl, method, body);
    }

    public CreateBelloJobResult createBelloJob(CreateBelloJobRequest createBelloJobRequest) throws IOException {
        Response response = upsertBelloJob(createBelloJobRequest);
        return new CreateBelloJobResult(response.peekBody(Long.MAX_VALUE).string());
    }

    public UpdateBelloJobResult updateBelloJob(UpdateBelloJobRequest updateBelloJobRequest) throws IOException {
        Response response = upsertBelloJob(updateBelloJobRequest);
        return new UpdateBelloJobResult(response.peekBody(Long.MAX_VALUE).string());
    }

    public GetBelloJobsResult getBelloJobs(GetBelloJobsRequest getBelloJobsRequest) throws IOException {
        String endpoint = getBelloJobsRequest.getEndpoint();
        String url = getBelloJobsRequest.getUrl();
        String method = getBelloJobsRequest.getMethod();
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(endpoint + url)).newBuilder();
        String whereStr = new ObjectMapper().writeValueAsString(getBelloJobsRequest.getWhere());
        if (whereStr != null && !whereStr.isEmpty()) {
            urlBuilder.addQueryParameter("where", whereStr);
        }
        String fullUrl = urlBuilder.build().toString();
        Response response = doOperation(fullUrl, method, null);
        return new GetBelloJobsResult(response.peekBody(Long.MAX_VALUE).string());
    }

    public GetBelloJobResult getBelloJob(GetBelloJobRequest getBelloJobRequest) throws IOException {
        String endpoint = getBelloJobRequest.getEndpoint();
        String url = getBelloJobRequest.getUrl();
        String method = getBelloJobRequest.getMethod();
        String fullUrl = endpoint + url;
        Response response = doOperation(fullUrl, method, null);
        return new GetBelloJobResult(response.peekBody(Long.MAX_VALUE).string());
    }
}
