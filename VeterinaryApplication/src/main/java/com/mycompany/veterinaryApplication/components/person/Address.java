package com.mycompany.veterinaryApplication.components.person;

import java.io.Serializable;

/**
 *
 * @author markc
 */
public class Address implements Serializable{
    // Instance Variables
    private int houseNumber;
    private String streetName;
    private String postcode;
    
    // Constructor to create an Address
    public Address(int houseNumber, String streetName, String postcode) { 
        this.houseNumber = houseNumber;
        this.streetName  = streetName;
        this.postcode = postcode;
    }
    
    // Simple GET Method
    public int getHouseNumber() {
        return this.houseNumber;
    }
    
    // Simple SET Method
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }
    
    public String getStreetName() {
        return this.streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
