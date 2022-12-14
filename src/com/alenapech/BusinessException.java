package com.alenapech;

public class BusinessException extends RuntimeException {

    private int code = 0;

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return (message != null && code != 0) ? (s + ": [" + code + "] " + message) : s;
    }
}
