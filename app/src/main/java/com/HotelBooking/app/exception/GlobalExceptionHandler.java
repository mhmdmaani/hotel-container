package com.HotelBooking.app.exception;

import com.HotelBooking.app.sender.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    // CUSTOM EXCEPTION
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<Object> customException(CustomException e) {
        logger.info(e.getClass().getName());
        String errorMessage = "Custom exception happened";

        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, e));
    }

    // BASE EXCEPTION
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info(e.getClass().getName());
        String errorMessage = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage, e));
    }

    // ALL EXCEPTIONS
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(Exception e) {
        logger.info(e.getClass().getName());
        logger.error("Error: ", e);
        String errorMessage = "An unexpected error occurred.";
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, e));
    }

}
