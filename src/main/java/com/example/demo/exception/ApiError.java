/**
 * Created by IntelliJ IDEA.
 * User: DatNH5
 * Date: 7/23/2018
 * Time: 4:04 PM
 **/
package com.example.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private String error;
    private String message;

    public ApiError() {
    }

    public ApiError(String error, String message) {
        this.error = error;
        this.message = message;
    }
}