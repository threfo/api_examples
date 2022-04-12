package com.belloai.api;

public class BelloClientException extends RuntimeException{
    private String errorMessage;
    private String errorCode;

    public BelloClientException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public BelloClientException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return getErrorMessage() + "\n[ErrorCode]: " + (errorCode != null ? errorCode : "");
    }
}
