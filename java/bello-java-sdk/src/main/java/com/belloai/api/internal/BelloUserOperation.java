package com.belloai.api.internal;
import com.belloai.api.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class BelloUserOperation extends GenericOperation{

    public GetsertAuthInfoResult getsertAuthInfo(GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException {
        String endpoint = getsertAuthInfoRequest.getEndpoint();
        String url = getsertAuthInfoRequest.getUrl();
        String method = getsertAuthInfoRequest.getMethod();
        String fullUrl = endpoint + url;
        BelloUser belloUser = getsertAuthInfoRequest.getUser();
        MediaType mediaType = MediaType.parse("application/json");
        ObjectMapper mapper = new ObjectMapper();
        RequestBody body = RequestBody.create(mediaType, mapper.writeValueAsString(belloUser));
        Response response = doOperation(fullUrl, method, body);
        return new GetsertAuthInfoResult(response.peekBody(Long.MAX_VALUE).string());
    }
}
