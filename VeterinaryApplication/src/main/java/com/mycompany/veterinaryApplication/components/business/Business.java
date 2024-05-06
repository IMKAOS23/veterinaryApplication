/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.components.Showable;
import com.mycompany.veterinaryApplication.components.person.Address;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author markc
 */
public abstract class Business implements Showable, Serializable{
    String name;
    Date openDate;
    Address address;
    List<Integer> animalList;
    
    /**
     * Constructs basic Business Object to be used with a subclass
     * 
     * @param name - Must be more than 2 Characters
     * @param openDate - In format of dd/mm/yyyy
     * @param houseNumber - Must be 0 or above
     * @param streetName - Must be more than 2 characters
     * @param postcode - Must be of UK Format
     * 
     * @throws ValidationException 
     */
    public Business(String name, Date openDate, int houseNumber, String streetName, String postcode) throws ValidationException {
        this.name = name;
        this.openDate = openDate;
        this.address = new Address(houseNumber, streetName, postcode);
        this.animalList = new ArrayList<>();
    }
    
    @Override
    public void addToShowList() {
        
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) throws ValidationException {
        this.name = name;
    }
    
    public Date getOpenDate() {
        return this.openDate;
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
    
    public void setStreetName(String streetName) throws ValidationException { 
        this.address.setStreetName(streetName);
    }
    
    public String getPostcode() {
        return this.address.getPostcode();
    }
    
    public void setPostcode(String postcode) throws ValidationException {
        this.address.setPostcode(postcode);
    }
    
    public void addAnimal(int animalId) {
        this.animalList.add(animalId);
    }
    
    public void removeAnimal(int animalId) {
        this.animalList.remove(animalId);
    }
}
