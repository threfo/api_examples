package com.belloai.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BelloJobs {
    private Map<String, Object> meta;
    private List<BelloJob> jobs;

    public BelloJobs() {
    }

    public BelloJobs(Map<String, Object> meta, List<BelloJob> jobs) {
        this.meta = meta;
        this.jobs = jobs;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public List<BelloJob> getJobs() {
        return jobs;
    }

    public void setJobs(List<BelloJob> jobs) {
        this.jobs = jobs;
    }
}
