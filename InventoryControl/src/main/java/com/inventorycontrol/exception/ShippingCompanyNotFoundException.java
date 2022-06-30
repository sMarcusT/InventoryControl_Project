package com.inventorycontrol.exception;

public class ShippingCompanyNotFoundException extends RuntimeException{

    public ShippingCompanyNotFoundException(String message){
        super(message);
    }
}
