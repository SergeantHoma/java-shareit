package ru.practicum.shareit.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.shareit.exception.NotFoundException;
import ru.practicum.shareit.exception.ValidationArgException;

@RestControllerAdvice
public class ErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        log.error("Resource not found: {}", e.getMessage(), e);
        return new ErrorResponse("NOT FOUND", e.getMessage());
    }

    // Другие ошибки, например, ошибки базы данных или конфликты
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleConflictException(ValidationArgException e) {
        log.error("Conflict: {}", e.getMessage(), e);
        return new ErrorResponse("CONFLICT", e.getMessage());
    }
}

