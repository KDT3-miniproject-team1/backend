package com.miniproject.backend.global.exception.base;

public abstract class CustomException extends RuntimeException{
    public abstract CustomExceptionType getExceptionType();
}
