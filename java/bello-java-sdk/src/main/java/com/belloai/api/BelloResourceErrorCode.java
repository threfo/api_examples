package com.belloai.api;

public interface BelloResourceErrorCode {
    /**
     * Access Denied (401)
     */
    static final String ACCESS_DENIED = "AccessDenied";

    /**
     * Access Forbidden (403)
     */
    static final String ACCESS_FORBIDDEN = "AccessForbidden";

    /**
     * Unprocessable Entity (422)
     */
    static final String UNPROCESSABLE_ENTITY = "UnprocessableEntity";

    /**
     * Not Found (404)
     */
    static final String NOT_FOUND = "NotFound";

    /**
     * Method Not Allowed (405)
     */
    static final String METHOD_NOT_ALLOWED = "MethodNotAllowed";

}
