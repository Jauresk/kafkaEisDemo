package com.eis.clientapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id){
        super("User #" + id + " Not founded !");
    }
}
