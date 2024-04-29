package com.waleed.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@Data
public class ApiException {
    private final String massage;
    private final HttpStatus httpStatus;
    private final ZonedDateTime zonedDateTime;
}
