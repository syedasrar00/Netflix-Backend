package com.netflix.backend.exceptions;

public class ServerErrorException extends RuntimeException{
    private String message;
    public ServerErrorException(String message){
        this.message =message;
    }
    @Override
    public String getMessage(){
        return this.message;
    }
}
