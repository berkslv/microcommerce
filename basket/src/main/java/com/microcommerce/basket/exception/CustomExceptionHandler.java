package com.microcommerce.basket.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Result> handleApiRequestException(ApiException exception) {
        Result result = new Result(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        log.info(exception.getMessage());
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Result> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String message = "Validation error:";
        for (var fieldError : exception.getBindingResult().getFieldErrors()) {
            message = message.concat(" " + fieldError.getField() + " " + fieldError.getDefaultMessage() + ".");
        }

        Result result = new Result(
                message,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        log.info(message);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
