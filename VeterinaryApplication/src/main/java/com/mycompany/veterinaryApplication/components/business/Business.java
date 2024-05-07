/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.business;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.person.Address;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markc
 */
public abstract class Business implements Serializable{
    String name;
    LocalDate openDate;
    Address address;
    List<Integer> animalList;
    
    /**
     * Constructs basic Business Object to be used with a subclass
     * 
     * @param name - Must be more than 2 Characters
     * @param openDate - In format of dd/mm/yyyy
     * 
     * @throws ValidationException 
     */
    public Business(String name, LocalDate openDate) throws ValidationException {
        if (App.validator.validateString(name, "Name")) {
            this.name = name;
        }
        
        if (App.validator.validateDate(openDate)) {
            this.openDate = openDate;
        }
        
        this.animalList = new ArrayList();
    }
    
    /**
     * Returns name of Business
     * 
     * @return name
     * 
     * @throws ValidationException 
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Allows the changing of Business name
     * 
     * @param name
     * 
     * @throws ValidationException 
     */
    public void setName(String name) throws ValidationException {
        if (App.validator.validateString(name, "Name")) {
            this.name = name;
        }
    }
    
    /**
     * Returns the Open Date of the Business
     * 
     * @return openDate 
     */
    public LocalDate getOpenDate() {
        return this.openDate;
    }
    
    /**
     * Feature not implemented however would allow you to add animal a business
     * 
     * @param animalId 
     */
    public void addAnimal(int animalId) {
        this.animalList.add(animalId);
    }
    
    /**
     * Feature not implemented however would allow you to remove animal from business
     * 
     * @param animalId 
     */
    public void removeAnimal(int animalId) {
        this.animalList.remove(animalId);
    }
}
