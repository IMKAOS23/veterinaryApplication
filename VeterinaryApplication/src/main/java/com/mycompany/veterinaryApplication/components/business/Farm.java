/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.time.LocalDate;

/**
 * Farm Class
 * Farm class while currently much differences over Zoo Class is seperated as allows for easier Scalability of Application
 * 
 * @author markc
 */
public class Farm extends Business{
    FarmAddress address;
    
    /**
     * Constructs a new Farm Object using specified name, opendate, address details
     * 
     * @param name
     * @param openDate
     * @param streetName
     * @param postcode
     * @param city
     * 
     * @throws ValidationException 
     */
    public Farm(String name, LocalDate openDate, String streetName, String postcode, String city) throws ValidationException {
        super(name, openDate);
        address = new FarmAddress(streetName, postcode, city);
        
    }
    
    // Figure Out something to seperate the business Farm - Zoo
}
