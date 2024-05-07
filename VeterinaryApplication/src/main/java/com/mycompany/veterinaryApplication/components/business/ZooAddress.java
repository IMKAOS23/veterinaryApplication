/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;

/**
 * ZooAddress Class
 * Seperate to FarmAddress to promote Scalability of Application
 * @author markc
 */
public class ZooAddress extends BusinessAddress {
    
    /**
     * Constructor for Zoo Addresses
     * Could house specific Zoo traits, such as number of Enclosures
     * 
     * @param streetName
     * @param postcode
     * @param city
     * 
     * @throws ValidationException 
     */
    public ZooAddress(String streetName, String postcode, String city) throws ValidationException {
        super(streetName, postcode, city);
    }
}
