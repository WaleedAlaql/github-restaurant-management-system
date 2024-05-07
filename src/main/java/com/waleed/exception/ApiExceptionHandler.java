package com.waleed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RestaurantNotFoundException.class)
    public ResponseEntity<Object> handleRestaurantNotFoundException(RestaurantNotFoundException exception){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MenuNotFoundException.class)
    public ResponseEntity<Object> handleMenuNotFoundException(MenuNotFoundException exception){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = MenuItemNotFoundException.class)
    public ResponseEntity<Object> handleMenuItemNotFoundException(MenuItemNotFoundException exception){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ReviewNotFoundException.class)
    public ResponseEntity<Object> handleReviewNotFoundException(ReviewNotFoundException exception){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException exception){

        ApiException apiException = new ApiException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }
}
