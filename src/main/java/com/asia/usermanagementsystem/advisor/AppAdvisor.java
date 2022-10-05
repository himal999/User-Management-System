package com.asia.usermanagementsystem.advisor;/*
author :Himal
version : 0.0.1
*/

import com.asia.usermanagementsystem.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AppAdvisor {
    @ExceptionHandler(RuntimeException.class)
    public Response uncheckedExceptionHandler(RuntimeException e) {
        return new Response(500, null, e.getMessage());
    }
}
