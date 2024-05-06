/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.exceptions;

/**
 * Custom Exception to be called if an Input Validation Fails
 * 
 * @author markc
 */
public class ValidationException extends Exception{
    /**
     * Constructs a new ValidationException to be Caught with a Try Catch block
     * 
     * @param message 
     */
    public ValidationException(String message) {
        super(message);
    } 
}
