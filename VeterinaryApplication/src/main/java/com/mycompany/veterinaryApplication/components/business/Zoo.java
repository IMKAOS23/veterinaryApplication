/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.time.LocalDate;

/**
 * Zoo Class
 * Zoo class while currently not much differences over Farm Class is seperated as allows for easier Scalability of the Application
 * 
 * @author markc
 */
public class Zoo extends Business {
    ZooAddress address;
    
    /**
     * Constructs a new Zoo with specified name, openDate and address details
     * 
     * @param name
     * @param openDate
     * @param streetName
     * @param postcode
     * @param city
     * 
     * @throws ValidationException 
     */
    public Zoo(String name, LocalDate openDate, String streetName, String postcode, String city) throws ValidationException {
        super(name, openDate);
        address = new ZooAddress(streetName, postcode, city);
    }
}
