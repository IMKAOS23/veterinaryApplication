/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.util.Date;

/**
 * Farm Class
 * Farm class while currently not providing any differences over Zoo Class is seperated as allows for easier Scalability of Application
 * 
 * @author markc
 */
public class Farm extends Business{
    public Farm(String name, Date openDate, int houseNumber, String streetName, String postcode) throws ValidationException {
        super(name, openDate, houseNumber, streetName, postcode);
    }
    
    // Figure Out something to seperate the business Farm - Zoo
}
