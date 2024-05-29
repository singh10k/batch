package com.Batch.in.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponseException> handleGenericException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErrorResponse(ExceptionMessage.INTERNAL_SERVER_ERROR.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        ExceptionMessage.INTERNAL_SERVER_ERROR.getErrorCode()));
    }

    @ExceptionHandler(FileWriteException.class)
    public ResponseEntity<RestResponseException> handleFileWriteException(FileWriteException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErrorResponse(exception.getMessage(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        ExceptionMessage.INTERNAL_SERVER_ERROR.getErrorCode()));
    }


    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<RestResponseException> handleDuplicateEntryException(DuplicateEntryException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(getErrorResponse(exception.getMessage(),
                        HttpStatus.CONFLICT.value(),
                        ExceptionMessage.INTERNAL_SERVER_ERROR.getErrorCode()));
    }

    public static RestResponseException getErrorResponse(String message, Integer statusCode, String errorCode) {
        return RestResponseException.builder().message(message).status(statusCode).build();
    }
}
