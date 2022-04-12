package com.belloai.api;

public class BelloClientBuilder implements ClientBuilder {
    public BelloClient build(final String authorization) {
        return new BelloClient(authorization);
    }
}
