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

    public String getJobId() {
        return job_id;
    }
    public void setJobId(String job_id) { this.job_id = job_id; }

    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelStatus() {
        return channel_status;
    }
    public void setChannelStatus(String channel_status) { this.channel_status = channel_status; }

    public String getJobCode() { return job_code; }
    public void setJobCode(String job_code) { this.job_code = job_code; }

    public Boolean getChanged() { return changed; }
    public void setChanged(Boolean changed) { this.changed = changed; }

    public Map<String, Object> getCustomAttributes() {
        return custom_attributes;
    }
    public void setCategory(Map<String, Object> custom_attributes) {
        this.custom_attributes = custom_attributes;
    }
}
