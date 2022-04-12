package com.belloai.api.model;

public class GetBelloJobRequest extends GenericRequest{

    public GetBelloJobRequest(final String jobId, final String endpoint) {
        super(endpoint, "/api/osr_job/" + jobId, "GET");
    }

    public GetBelloJobRequest(final String endpoint, final String url , final String method) {
        super(endpoint, url, method);
    }
}
