package com.reserva.hoteles.exceptions;

public class DeleteErrorException extends RuntimeException{
    public DeleteErrorException(String message) {
        super(message);
    }
}
