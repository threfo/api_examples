package com.belloai.api.internal;

import com.belloai.api.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class BelloCustomerChannelOperation extends GenericOperation {
    public SyncBelloCustomerChannelResult syncCustomerChannel(SyncBelloCustomerChannelRequest syncBelloCustomerChannelRequest) throws IOException {
        String endpoint = syncBelloCustomerChannelRequest.getEndpoint();
        String url = syncBelloCustomerChannelRequest.getUrl();
        String method = syncBelloCustomerChannelRequest.getMethod();
        String fullUrl = endpoint + url;
        BelloCustomerChannelList channelList = syncBelloCustomerChannelRequest.getChannel_list();

        MediaType mediaType = MediaType.parse("application/json");
        ObjectMapper mapper = new ObjectMapper();
        RequestBody body = RequestBody.create(mediaType, mapper.writeValueAsString(channelList));
        Response response = doOperation(fullUrl, method, body);
        return new SyncBelloCustomerChannelResult(response.peekBody(Long.MAX_VALUE).string());
    }
}
