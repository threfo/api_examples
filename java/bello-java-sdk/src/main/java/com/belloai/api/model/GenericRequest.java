package com.belloai.api.model;

public abstract class GenericRequest {
    private String endpoint;
    private String url;
    private String method;

    public GenericRequest() {
    }

    public GenericRequest(final String endpoint, final String url, final String method) {
        this.endpoint = endpoint;
        this.url = url;
        this.method = method;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getUrl() {
        return this.url;
    }

    public String getMethod() {
        return this.method;
    }
}
