package com.belloai.api.model;

public class UpdateBelloJobRequest extends JobRequest{
    private BelloJob job;

    public UpdateBelloJobRequest(BelloJob job, final String endpoint) {
        super(job, endpoint, "/api/osr_job/" + job.getId() + "/update", "POST");
    }

    public UpdateBelloJobRequest(BelloJob job, final String endpoint, final String url , final String method) {
        super(job, endpoint, url, method);
    }
}
