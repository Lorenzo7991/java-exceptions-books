package org.exercise.library.model;

// Custom exception class for handling invalid book data
public class InvalidBookDataException extends RuntimeException {
    // Constructor that takes a custom error message
    public InvalidBookDataException(String message) {
        super(message);
    }
}
