package br.com.concrete.challenge.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long exception) {
        super(String.valueOf(exception));
    }
}
