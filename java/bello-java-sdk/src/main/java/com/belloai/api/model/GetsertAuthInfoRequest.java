package com.belloai.api.model;

public class GetsertAuthInfoRequest extends GenericRequest{
    private BelloUser user;

    public GetsertAuthInfoRequest(BelloUser user, final String endpoint) {
        super(endpoint, "/api/v2/user/getsert_auth_info", "POST");
        setUser(user);
    }

    public GetsertAuthInfoRequest(BelloUser user, final String endpoint, final String url , final String method) {
        super(endpoint, url, method);
        setUser(user);
    }

    public BelloUser getUser() {
        return user;
    }

    public void setUser(BelloUser user) {
        this.user = user;
    }
}
