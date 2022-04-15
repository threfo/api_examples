package com.belloai.api;

import com.belloai.api.model.SyncBelloCustomerChannelRequest;
import com.belloai.api.model.SyncBelloCustomerChannelResult;

import java.io.IOException;

public interface BelloCustomerChannel {
    public SyncBelloCustomerChannelResult syncCustomerChannel(SyncBelloCustomerChannelRequest syncBelloCustomerChannelRequest) throws IOException;
}
