package com.mycompany.veterinaryApplication.components.person;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.Showable;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;

/**
 *
 * @author markc
 */
public abstract class Person implements Showable, Serializable{
    private String firstName;
    private String lastName;
    private int age; 
    private String email;
    private String phoneNumber;
    private final Address address;
    
    
    /**
     * 
     * @param firstName - Must be more than 2 characters without Spaces
     * @param lastName - Must be more than 2 characters without Spaces
     * @param age - Must be greater than 0
     * @param email - Must be a valid email format such as "example@example.com"
     * @param phoneNumber - Must be valid UK phone number format such as 07333444555
     * @param houseNumber - Must be greater than 0
     * @param streetName - Must be more than 2 characters with Spaces
     * @param postcode - Must be of UK postcode format such as M17 3GA
     * 
     * @throws ValidationException 
     */
    public Person(String firstName, String lastName, int age, String email, String phoneNumber, int houseNumber, String streetName, String postcode) throws ValidationException {
        App.openClinic.increasePersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = new Address(houseNumber, streetName, postcode);
    }
    
    @Override
    public void addToShowList() {
        
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getHouseNumber() {
        return this.address.getHouseNumber();
    }
    
    public void setHouseNumber(int houseNumber) throws ValidationException {
        this.address.setHouseNumber(houseNumber);
    }
    
    public String getStreetName() {
        return this.address.getStreetName();
    }
    
    public void setStreetName(String streetName) throws ValidationException{
        this.address.setStreetName(streetName);
    }
    
    public String getPostcode() {
        return this.address.getPostcode();
    }
    
    public void setPostcode(String postcode) throws ValidationException{
        this.address.setPostcode(postcode);
    }
}
