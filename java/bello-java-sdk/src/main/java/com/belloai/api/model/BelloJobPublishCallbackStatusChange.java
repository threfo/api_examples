package com.belloai.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BelloJobPublishCallbackStatusChange {
    private String job_id;
    private String channel;
    private String channel_status;
    private String job_code;
    private Boolean changed;
    private Map<String, Object> custom_attributes;

    public String getJob_id() {
        return job_id;
    }
    public void setJob_id(String job_id) { this.job_id = job_id; }

    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannel_status() {
        return channel_status;
    }
    public void setChannel_status(String channel_status) { this.channel_status = channel_status; }

    public String getJob_code() { return job_code; }
    public void setJob_code(String job_code) { this.job_code = job_code; }

    public Boolean getChanged() { return changed; }
    public void setChanged(Boolean changed) { this.changed = changed; }

    public Map<String, Object> getCustom_attributes() {
        return custom_attributes;
    }
    public void setCustom_attributes(Map<String, Object> custom_attributes) {
        this.custom_attributes = custom_attributes;
    }
}
