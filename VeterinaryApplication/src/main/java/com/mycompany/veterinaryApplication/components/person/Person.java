package com.mycompany.veterinaryApplication.components.person;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;

/**
 *
 * @author markc
 */
public abstract class Person implements Serializable{
    private String firstName;
    private String lastName;
    private int age; 
    private String email;
    private String phoneNumber;
    private final Address address;
    
    
    /**
     * Constructs a new Person object with specified fname, lname, age, email, phone and address details
     * 
     * @param firstName - String
     * @param lastName - String
     * @param age - Int
     * @param email - String
     * @param phoneNumber - String
     * @param houseNumber - Int
     * @param streetName - String
     * @param postcode - String
     * @param city - String
     * 
     * @throws ValidationException 
     */
    public Person(String firstName, String lastName, String age, String email, String phoneNumber, String houseNumber, String streetName, String postcode, String city) throws ValidationException {
        if (App.validator.validateString(firstName, "First Name")) {
            this.firstName = firstName;
        }
        
        if (App.validator.validateString(lastName, "Last Name")) {
            this.lastName = lastName;
        }
        
        int intAge = App.validator.convertToInteger(age, "Age");
        if (App.validator.validateInt(intAge, "Age")) {
            this.age = intAge;
        }
        
        if (App.validator.validateEmail(email)) {
            this.email = email;
        }
        
        if (App.validator.validatePhone(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        
        this.address = new Address(houseNumber, streetName, postcode, city);
    }
    /**
     * Returns First name of Person
     * 
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * Allows changing of Person's First Name
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setFirstName(String input) throws ValidationException {
        if (App.validator.validateString(input, "First Name")) {
            this.firstName = input;
        }
    }
        
    /**
     * Returns last name of Person
     * 
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * Allows Changing of Person's Last Name
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setLastName(String input) throws ValidationException {
        if (App.validator.validateString(input, "Last Name")) {
            this.lastName = input;
        }
    }
    
    /**
     * Returns Age of Person
     * 
     * @return age
     */
    public int getAge() {
        return this.age;
    }
    
    /**
     * Allows changing of Person's age
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setAge(String input) throws ValidationException {
        int intAge = App.validator.convertToInteger(input, "Age");
        if (App.validator.validateInt(intAge, "First Name")) {
            this.age = intAge;
        }
    }
    
    /**
     * Returns Email of Person
     * 
     * @return email
     */
    public String getEmail() {
        return this.email;
    }
    
    /**
     * Allows changing of Persons email
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setEmail(String input) throws ValidationException {
        if (App.validator.validateEmail(input)) {
            this.email = input;
        }
    }
    
    /**
     * Returns phone number of person
     * 
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    /**
     * Allows changing of Person's phone number
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setPhoneNumber(String input) throws ValidationException {
        if (App.validator.validatePhone(input)) {
            this.phoneNumber = input;
        }
    }
    
    /**
     * Returns house number of Person's Address
     * 
     * @return Address.houseNumber
     */
    public int getHouseNumber() {
        return this.address.getHouseNumber();
    }
    
    /**
     * Allows changing of Person's Address house number
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setHouseNumber(String input) throws ValidationException {
        this.address.setHouseNumber(input);
    }
    
    /**
     * Returns street name of Person's Address
     * 
     * @return Address.streetName
     */
    public String getStreetName() {
        return this.address.getStreetName();
    }
    
    /**
     * Allows changing of Person's Address street name
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setStreetName(String input) throws ValidationException{
        this.address.setStreetName(input);
    }
    
    /**
     * Returns postcode of Person's Address
     * 
     * @return Address.postcode
     */
    public String getPostcode() {
        return this.address.getPostcode();
    }
    
    /**
     * Allows changing of Person's Address postcode
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setPostcode(String input) throws ValidationException{
        this.address.setPostcode(input);
    }
    
    /**
     * Returns city of Person's Address
     * 
     * @return Address.city
     */
    public String getCity() {
        return this.address.getCity();
    }
    
    /**
     * Allows changing of Person's Address city
     * 
     * @param input
     * 
     * @throws ValidationException 
     */
    public void setCity(String input) throws ValidationException {
        this.address.setCity(input);
    }
}