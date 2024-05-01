package com.mycompany.veterinaryApplication.components.person;

import com.mycompany.veterinaryApplication.App;
import java.io.Serializable;

/**
 *
 * @author markc
 */
public abstract class Person implements Serializable{
    private final int id;
    private String firstName;
    private String lastName;
    private int age; 
    private String phoneNumber;
    private final Address address;
    
    public Person(String firstName, String lastName, int age, String phoneNumber, int houseNumber, String streetName, String postcode) {
        this.id = App.openClinic.getLastPersonId() + 1;
        App.openClinic.increasePersonId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = new Address(houseNumber, streetName, postcode);
    }
    
    public int getId() {
        return this.id;
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
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getHouseNumber() {
        return this.address.getHouseNumber();
    }
    
    public void setHouseNumber(int houseNumber) {
        this.address.setHouseNumber(houseNumber);
    }
    
    public String getStreetName() {
        return this.address.getStreetName();
    }
    
    public void setStreetName(String streetName) {
        this.address.setStreetName(streetName);
    }
    
    public String getPostcode() {
        return this.address.getPostcode();
    }
    
    public void setPostcode(String postcode) {
        this.address.setPostcode(postcode);
    }
}
