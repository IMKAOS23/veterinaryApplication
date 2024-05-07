/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;

/**
 * BusinessAddress Class
 * Used for Businesses such as Farms and Zoos which dont have normal Addresses
 * 
 * @author markc
 */
public abstract class BusinessAddress implements Serializable {
    String streetName;
    String postcode;
    String city;
    
    /**
     * Constructor - Constructs a new Business Address for a business
     * 
     * @param streetName
     * @param postcode
     * @param city
     * 
     * @throws ValidationException 
     */
    public BusinessAddress(String streetName, String postcode, String city) throws ValidationException  {
        if (App.validator.validateString(streetName, "Street Name")) {
            this.streetName = streetName;
        }
        
        if (App.validator.validatePostcode(postcode)) {
            this.postcode = postcode;
        }
        
        if (App.validator.validateString(city, "City")) {
            this.city = city;
        }
    }
    
    /**
     * Returns streetName of Business address
     * 
     * @return streetName
     */
    public String getStreetName() {
        return this.streetName;
    }
    
    /**
     * Allows the changing of business address streetName
     * 
     * @param streetName
     * 
     * @throws ValidationException 
     */
    public void setStreetName(String streetName) throws ValidationException {
        if (App.validator.validateString(streetName, "Street Name")) {
            this.streetName = streetName;
        }
    }
    
    /**
     * Returns the postcode of business address
     * 
     * @return postcode
     */
    public String getPostcode() {
        return this.postcode;
    }
    
    /**
     * Allows the changing of business address postcode
     * @param postcode
     * @throws ValidationException 
     */
    public void setPostcode(String postcode) throws ValidationException {
        if (App.validator.validatePostcode(postcode)) {
            this.postcode = postcode;
        }
    }
    
    /**
     * Returns city of business address
     * 
     * @return city 
     */
    public String getCity() {
        return this.city;
    }
    
    /**
     * Allows the changing of Business Address city
     * 
     * @param city
     * 
     * @throws ValidationException 
     */
    public void setCity(String city) throws ValidationException {
        if (App.validator.validateString(city, "City")) {
            this.city = city;
        }
    }
}
