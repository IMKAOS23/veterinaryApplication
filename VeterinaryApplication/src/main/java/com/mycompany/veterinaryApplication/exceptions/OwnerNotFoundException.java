/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.exceptions;

/**
 * Custom Exception to be called if Owner of Animal not found in Clinic
 * @author markc
 */
public class OwnerNotFoundException extends Exception{
    /**
     * Constructs a new OwnerNotFoundException to be caught with Try Catch Block
     * 
     * @param message 
     */
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
