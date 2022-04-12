package com.belloai.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class GetBelloJobResult extends GenericResult{
    public GetBelloJobResult(String operationResult) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.readValue(operationResult, new TypeReference<Map<String, Object>>() {});
        setData(result);
    }
}
