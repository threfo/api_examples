package com.belloai.api.model;

import java.util.List;
import java.util.Map;

public class GetBelloJobsRequest extends GenericRequest{
    private Map<String, Object> where;

    public Map<String, Object> getWhere() {
        return where;
    }

    public void setWhere(Map<String, Object> where) {
        this.where = where;
    }

    public GetBelloJobsRequest(final String endpoint) {
        super(endpoint, "/api/osr_job", "GET");
    }

    public GetBelloJobsRequest(final String endpoint, final String url , final String method) {
        super(endpoint, url, method);
    }
}
