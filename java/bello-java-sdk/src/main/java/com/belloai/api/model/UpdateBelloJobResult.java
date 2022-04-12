package com.belloai.api.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class UpdateBelloJobResult extends GenericResult{
    public UpdateBelloJobResult(String operationResult) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = mapper.readValue(operationResult, new TypeReference<Map<String, Object>>() {});
        setCode((Integer) result.get("code"));
        setMessage((String) result.get("message"));
        setData((Map<String, Object>) result.get("data"));
    }
}
