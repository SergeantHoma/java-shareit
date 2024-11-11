package ru.practicum.shareit.error;

import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.practicum.shareit.exception.InvalidRequestException;
import ru.practicum.shareit.exception.ValidationArgException;

@RestController
public class ErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestException(InvalidRequestException e) {
        log.error("Invalid request: {}", e.getMessage(), e);
        return new ErrorResponse("BAD REQUEST", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleValidationArgException(ValidationArgException e) {
        log.error("Validation conflict: {}", e.getMessage(), e);
        return new ErrorResponse("CONFLICT", e.getMessage());
    }
}
