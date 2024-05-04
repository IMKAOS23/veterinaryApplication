/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.util.Date;

/**
 * Zoo Class
 * Zoo class while currently not providing any differences over Farm Class is seperated as allows for easier Scalability of the Application
 * 
 * @author markc
 */
public class Zoo extends Business {
    public Zoo(String name, Date openDate, int houseNumber, String streetName, String postcode) throws ValidationException {
        super(name, openDate, houseNumber, streetName, postcode);
    }
}
