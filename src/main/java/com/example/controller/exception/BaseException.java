package com.example.controller.exception;

public class BaseException extends RuntimeException{

    private  Integer retCode;


    public BaseException(String message) {
        super(message);
        this.retCode =201;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "retCode=" + retCode +
                '}';
    }
}
