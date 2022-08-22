package com.study.store.Config.Exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleAnyExceptions(Exception e, WebRequest request) {
        String errorDescription = e.getLocalizedMessage();
        String error[] = new String[3];

        if (errorDescription == null)
            errorDescription = e.toString();

        error = errorDescription.split("//:");

        ErrorMessage errorMessage = new ErrorMessage(new Date(), error[1]);
        if (errorMessage.getError() == null)
            errorMessage = new ErrorMessage(new Date(), e.getLocalizedMessage());

        return ResponseEntity.status(Integer.parseInt(error[2])).body(errorMessage);
    }
}
