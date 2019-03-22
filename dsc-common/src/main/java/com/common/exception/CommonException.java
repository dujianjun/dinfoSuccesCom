package com.common.exception;


public class CommonException extends Exception {

    private String messageCode;

    public CommonException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }

    public CommonException(String message) {
        super(message);
    }

    public String getMessageCode() {
        return this.messageCode;
    }
}
