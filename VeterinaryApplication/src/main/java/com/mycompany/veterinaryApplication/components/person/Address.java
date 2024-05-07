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
    private String city;
    
    /**
     * Constructs a new Address object with specified houseNumber, streetName and postcode
     * 
     * @param houseNumber - Must be Above 0
     * @param streetName
     * @param postcode - Must be of UK Postcode Format 
     * @param city 
     * 
     * @throws ValidationException
     */
    public Address(String houseNumber, String streetName, String postcode, String city) throws ValidationException {
        int newInt = App.validator.convertToInteger(houseNumber, "House Number");
        if (App.validator.validateInt(newInt, "House Number")) {
            this.houseNumber = newInt;
        }
        
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
     * @throws ValidationException
     */
    public void setHouseNumber(String houseNumber) throws ValidationException {
        int newInt = App.validator.convertToInteger(houseNumber, "House Number");
        if (App.validator.validateInt(newInt, "House Number")) {
            this.houseNumber = newInt;
        }
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
     * @throws ValidationException
     */
    public void setStreetName(String streetName) throws ValidationException {
        if (App.validator.validateString(streetName, "Street Name")) {
            this.streetName = streetName;
        }
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
     * @throws ValidationException
     */
    public void setPostcode(String postcode) throws ValidationException {
        if (App.validator.validatePostcode(postcode)) {
            this.postcode = postcode;   
        }
    }
    
    /**
     * Returns City of address
     * 
     * @return city
     */
    public String getCity() {
        return this.city;
    }
    
    /**
     * Allows the changing of Address City
     * 
     * @param city - Must be 2 or more Characters long 
     * 
     * @throws ValidationException 
     */
    public void setCity(String city) throws ValidationException {
        if (App.validator.validateString(city, "City")) {
            this.city = city;
        }
    }
}
