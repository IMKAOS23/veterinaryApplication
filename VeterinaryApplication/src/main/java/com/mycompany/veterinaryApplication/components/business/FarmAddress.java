/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;

/**
 * FarmAddress Class
 * Seperate from ZooAddress to promote Scalability of Application
 * 
 * @author markc
 */
public class FarmAddress extends BusinessAddress {
    /**
     * Constructor for new Farm Addresses
     * Could house farm specific details
     * 
     * @param streetName
     * @param postcode
     * @param city
     * 
     * @throws ValidationException 
     */
    public FarmAddress(String streetName, String postcode, String city) throws ValidationException {
        super(streetName, postcode, city);
    }
}
