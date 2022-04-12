package com.belloai.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class GetBelloJobsResult extends GenericResult{
    public GetBelloJobsResult(String operationResult) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.readValue(operationResult, new TypeReference<Map<String, Object>>() {});
        setMeta((Map<String, Object>) result.get("meta"));
        setItems((List<Object>) result.get("items"));
    }
}
