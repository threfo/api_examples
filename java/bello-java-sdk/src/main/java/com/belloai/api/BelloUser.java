package com.belloai.api;

import com.belloai.api.model.*;

import java.io.IOException;

public interface BelloUser {
    public BelloUserAuthInfo getsertAuthInfo(GetsertAuthInfoRequest getsertAuthInfoRequest) throws IOException;
}
