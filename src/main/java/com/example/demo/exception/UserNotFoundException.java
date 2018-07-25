/**
 * Created by IntelliJ IDEA.
 * User: DatNH5
 * Date: 7/23/2018
 * Time: 3:44 PM
 **/
package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("Invalid username or password");
    }
}
