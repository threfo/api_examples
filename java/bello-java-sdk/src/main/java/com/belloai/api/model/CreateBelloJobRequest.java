package com.belloai.api.model;

public class CreateBelloJobRequest extends JobRequest{
    private BelloJob job;

    public CreateBelloJobRequest(BelloJob job, final String endpoint) {
        super(job, endpoint, "/api/osr_job/create", "POST");
    }

    public CreateBelloJobRequest(BelloJob job, final String endpoint, final String url , final String method) {
        super(job, endpoint, url, method);
    }
}
