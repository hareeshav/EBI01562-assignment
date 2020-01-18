package com.hareesh.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hareesh.demo.dto.ApiResponse;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse handleNotFoundException(RuntimeException ex) {
        ApiResponse apiResponse = new ApiResponse(400, "Bad request", null);
        return apiResponse;
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ApiResponse handleUserNotFoundException(UserNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(404, ex.getLocalizedMessage(), null);
        return apiResponse;
    }

}
