package com.example.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
//@ControllerAdvice(annotations = {RestController})
@RestController
@Slf4j
public class GlobaExceptionHandler {


    @ExceptionHandler(BaseException.class)
    public String exceptionHandler(BaseException e){
          log.error(e.getMessage());
          return  e.getMessage();
    }
}
