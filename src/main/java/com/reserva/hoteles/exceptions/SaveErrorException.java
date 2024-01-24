package com.reserva.hoteles.exceptions;

public class SaveErrorException extends RuntimeException {
    public SaveErrorException(String message) {
        super(message);
    }
}
