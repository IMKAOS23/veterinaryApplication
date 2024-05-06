package com.mycompany.veterinaryApplication.components.person;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;

/**
 * Address Class
 * Allows the creation of Address objects to be used with People to better store address information
 * 
 * @author markc
 */
public class Address implements Serializable{
    private int houseNumber;
    private String streetName;
    private String postcode;
    
    /**
     * Constructs a new Address object with specified houseNumber, streetName and postcode
     * 
     * @param houseNumber - Must be Above 0
     * @param streetName
     * @param postcode - Must be of UK Postcode Format 
     * 
     * @throws ValidationException if houseNumber or postcode fails Validation
     */
    public Address(int houseNumber, String streetName, String postcode) throws ValidationException {
        if (!App.validator.validateInt(houseNumber)) {
            throw new ValidationException("Validation Error: houseNumber must be above 0");
        }
        
        if (!App.validator.validateName(streetName)) {
            throw new ValidationException("Validation Error: streetName must be more than 2 characters");
        }
        
        if (!App.validator.validatePostcode(postcode)) {
            throw new ValidationException("Validation Error: postcode is not of UK format");
        }
        
        this.houseNumber = houseNumber;
        this.streetName  = streetName;
        this.postcode = postcode;
    }
    
    /**
     * Returns houseNumber of Address Object
     * 
     * @return houseNumber 
     */
    public int getHouseNumber() {
        return this.houseNumber;
    }
    
    /**
     * Allows the changing of Address houseNumber
     * 
     * @param houseNumber - Must be above 0
     * 
     * @throws ValidationException if less than 0
     */
    public void setHouseNumber(int houseNumber) throws ValidationException {
        if (!App.validator.validateInt(houseNumber)) {
            throw new ValidationException("Validation Error: houseNumber must be above 0");
        }
        this.houseNumber = houseNumber;
    }
    
    /**
     * Returns streetName of Address
     * 
     * @return streetName
     */
    public String getStreetName() {
        return this.streetName;
    }
    
    /**
     * Allows Changing of Address streetName
     * 
     * @param streetName - Must contain more than 2 characters without spaces
     * 
     * @throws ValidationException if less than 2 characters
     */
    public void setStreetName(String streetName) throws ValidationException {
        if (!App.validator.validateName(streetName)) {
            throw new ValidationException("Validation Error: streetName must be more than 2 characters");
        }
        this.streetName = streetName;
    }
    
    /**
     * Returns postcode of address
     * 
     * @return postcode
     */
    public String getPostcode() {
        return this.postcode;
    }
    
    /**
     * Allows changing of Address postcode
     * 
     * @param postcode - Must be of UK Format
     * 
     * @throws ValidationException if not of UK Format
     */
    public void setPostcode(String postcode) throws ValidationException {
        if (!App.validator.validatePostcode(postcode)) {
            throw new ValidationException("Validation Error: postcode must be of UK format");
        }
        this.postcode = postcode;
    }
}
