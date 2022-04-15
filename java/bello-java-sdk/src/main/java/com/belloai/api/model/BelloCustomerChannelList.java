package com.belloai.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.HashMap;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BelloCustomerChannelList {
    private ArrayList<HashMap<String, Object>> channel_list;

    public ArrayList<HashMap<String, Object>> getChannel_list() {
        return channel_list;
    }
    public void setChannel_list(ArrayList<HashMap<String, Object>> channel_list) {
        this.channel_list = channel_list;
    }
}
