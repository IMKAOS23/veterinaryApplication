/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.exceptions;

/**
 *
 * @author markc
 */
public class NotFoundException extends Exception {
    
    /**
     * Constructs a new NotFoundException to be caught with Try Catch Block
     * 
     * @param message 
     */
    public NotFoundException(String message) {
        super(message);
    }
}
