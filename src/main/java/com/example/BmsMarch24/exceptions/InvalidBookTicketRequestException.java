package com.example.BmsMarch24.exceptions;

public class InvalidBookTicketRequestException extends RuntimeException{
    public InvalidBookTicketRequestException() {
    }

    public InvalidBookTicketRequestException(String message) {
        super(message);
    }

    public InvalidBookTicketRequestException(Throwable cause) {
        super(cause);
    }
}
