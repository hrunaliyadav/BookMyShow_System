package com.example.BmsMarch24.exceptions;

public class SeatUnavailableException extends RuntimeException{
    public SeatUnavailableException() {
    }

    public SeatUnavailableException(String message) {
        super(message);
    }

    public SeatUnavailableException(Throwable cause) {
        super(cause);
    }
}
