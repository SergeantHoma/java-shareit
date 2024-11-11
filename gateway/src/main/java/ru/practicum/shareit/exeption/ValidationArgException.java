package ru.practicum.shareit.exeption;

public class ValidationArgException extends RuntimeException {
    public ValidationArgException(String message) {
        super(message);
    }
}
