package com.belloai.api.model;

public abstract class JobRequest extends GenericRequest{
    private BelloJob job;

    public JobRequest(BelloJob job, final String endpoint, final String url , final String method) {
        super(endpoint, url, method);
        setJob(job);
    }

    public BelloJob getJob() {
        return job;
    }

    public void setJob(BelloJob job) {
        this.job = job;
    }
}
