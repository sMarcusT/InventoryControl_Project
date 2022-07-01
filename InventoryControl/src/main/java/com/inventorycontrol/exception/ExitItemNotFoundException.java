package com.inventorycontrol.exception;

public class ExitItemNotFoundException extends RuntimeException {

    public ExitItemNotFoundException(String message) {
        super(message);
    }
}
