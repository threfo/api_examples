package com.belloai.api;

import com.belloai.api.internal.BelloCustomerChannelOperation;
import com.belloai.api.internal.BelloJobOperation;
import com.belloai.api.internal.BelloUserOperation;
import com.belloai.api.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

public class BelloClient implements BelloJob, BelloUser, BelloCustomerChannel {
    private BelloJobOperation belloJobOperation;
    private BelloUserOperation belloUserOperation;
    private BelloCustomerChannelOperation belloCustomerChannelOperation;

    private void initOperations() {
        belloJobOperation = new BelloJobOperation();
        belloUserOperation = new BelloUserOperation();
        belloCustomerChannelOperation = new BelloCustomerChannelOperation();
    }

    public BelloClient(String authorization) {
        initOperations();
        belloJobOperation.setAuthorization(authorization);
        belloUserOperation.setAuthorization(authorization);
        belloCustomerChannelOperation.setAuthorization(authorization);
    }

    private com.belloai.api.model.BelloJob getGenericJob(Integer code, String message, Map<String, Object> data) {
        if (code != null && !code.equals(0)) {
            throw new BelloClientException(message, code.toString());
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.convertValue(data, com.belloai.api.model.BelloJob.class);
        }
    }

    private com.belloai.api.model.BelloJob getGenericJob(GenericResult result) {
        return getGenericJob(result.getCode(), result.getMessage(), result.getData());
    }

    @Override
    public com.belloai.api.model.BelloJob createBelloJob(CreateBelloJobRequest createBelloJobRequest) throws IOException {
        CreateBelloJobResult createBelloJobResult = belloJobOperation.createBelloJob(createBelloJobRequest);
        return getGenericJob(createBelloJobResult);
    }

    @Override
    public com.belloai.api.model.BelloJob getBelloJob(GetBelloJobRequest getBelloJobRequest) throws IOException {
        GetBelloJobResult getBelloJobResult = belloJobOperation.getBelloJob(getBelloJobRequest);
        return getGenericJob(null, null, getBelloJobResult.getData());
    }

    @Override
    public com.belloai.api.model.BelloJob updateBelloJob(String jobId, UpdateBelloJobRequest updateBelloJobRequest) throws IOException {
        updateBelloJobRequest.getJob().setId(jobId);
        UpdateBelloJobResult updateBelloJobResult = belloJobOperation.updateBelloJob(updateBelloJobRequest);
        return getGenericJob(updateBelloJobResult);
    }

    @Override
    public BelloJobs getBelloJobs(GetBelloJobsRequest getBelloJobsRequest) throws IOException {
        GetBelloJobsResult getBelloJobsResult = belloJobOperation.getBelloJobs(getBelloJobsRequest);
        ObjectMapper mapper = new ObjectMapper();
        List<com.belloai.api.model.BelloJob> jobs = mapper.convertValue(getBelloJobsResult.getItems(), new TypeReference<List<com.belloai.api.model.BelloJob>>() {});
        return new BelloJobs(getBelloJobsResult.getMeta(), jobs);
    }

    @Override
    public String getBelloJobAdUrl(String jobId, GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException {
        BelloUserAuthInfo belloUserAuthInfo = getsertAuthInfo(getsertAuthInfoRequest);
        return getsertAuthInfoRequest.getEndpoint() + "/osr/channels-manage?jobId=" + jobId + "&token=" + belloUserAuthInfo.getToken();
    }

    @Override
    public String getBelloJobAdUrl(String url, String jobId, GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException {
        BelloUserAuthInfo belloUserAuthInfo = getsertAuthInfo(getsertAuthInfoRequest);
        return getsertAuthInfoRequest.getEndpoint() + url + "?jobId=" + jobId + "&token=" + belloUserAuthInfo.getToken();
    }

    @Override
    public BelloUserAuthInfo getsertAuthInfo(GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException {
        GetsertAuthInfoResult getsertAuthInfoResult = belloUserOperation.getsertAuthInfo(getsertAuthInfoRequest);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(getsertAuthInfoResult.getData(), BelloUserAuthInfo.class);
    }

    @Override
    public SyncBelloCustomerChannelResult syncCustomerChannel(SyncBelloCustomerChannelRequest syncBelloCustomerChannelRequest) throws IOException {
        return belloCustomerChannelOperation.syncCustomerChannel(syncBelloCustomerChannelRequest);
    }
}
