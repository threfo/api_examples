package com.belloai.api.model;

public class SyncBelloCustomerChannelRequest extends GenericRequest{
    private BelloCustomerChannelList channel_list;

    public SyncBelloCustomerChannelRequest(BelloCustomerChannelList channel_list, String endpoint) {
        super(endpoint, "/api/customer_channel/sync", "POST");
        setChannel_list(channel_list);
    }

    public BelloCustomerChannelList getChannel_list() {
        return channel_list;
    }

    public void setChannel_list(BelloCustomerChannelList channel_list) {
        this.channel_list = channel_list;
    }
}
