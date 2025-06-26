package com.D33.CURDOpration.exception;

public class UserNotFoundException extends RuntimeException{
    public  UserNotFoundException(Long id){
        super("Id not found : "+id);
    }
}
