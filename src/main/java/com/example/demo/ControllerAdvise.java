/**
 * Created by IntelliJ IDEA.
 * User: DatNH5
 * Date: 7/23/2018
 * Time: 3:43 PM
 **/
package com.example.demo;

import com.example.demo.exception.ApiError;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class ControllerAdvise {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(final UserNotFoundException e) {
        return error(e, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ApiError> error(final Exception exception, final HttpStatus httpStatus) {
        final String message =
                Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());

        return new ResponseEntity<>(new ApiError(httpStatus.toString(), message), HttpStatus.NOT_FOUND);
    }
}
