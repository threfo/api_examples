package com.belloai.api;

import com.belloai.api.model.*;
import com.belloai.api.model.BelloUser;

import java.io.IOException;

public interface BelloJob {
    public com.belloai.api.model.BelloJob createBelloJob(CreateBelloJobRequest createBelloJobRequest) throws IOException;
    public com.belloai.api.model.BelloJob getBelloJob(GetBelloJobRequest getBelloJobRequest) throws IOException;
    public com.belloai.api.model.BelloJob updateBelloJob(String jobId, UpdateBelloJobRequest updateBelloJobRequest) throws IOException;
    public BelloJobs getBelloJobs(GetBelloJobsRequest getBelloJobsRequest) throws IOException;
    public String getBelloJobAdUrl(String jobId, GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException;
    public String getBelloJobAdUrl(String url, String jobId, GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException;
}
