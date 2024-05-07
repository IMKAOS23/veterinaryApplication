/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.Tuple;
import com.mycompany.veterinaryApplication.exceptions.OwnerNotFoundException;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Animal Class - Abstract Class that implements the Serializable interface to allow the serialization of objects
 * which inherit from the Animal class
 * 
 * Sets up the Basic Functionality of Animals such as Name, Age, Colour, Species, Appointment List
 * 
 * @author markc
 */
public abstract class Animal implements Serializable{
    private String name;
    private int age;
    private String colour;
    private String species;
    private final int owner;
    
    /**
     * Constructs a basic Animal object, called using super() method in a subclasses constructor
     * 
     * @param name - String
     * @param age - Integer
     * @param colour - String
     * @param species - String
     * 
     * @throws ValidationException 
     */
    public Animal(String name, String age, String colour, String species, int id) throws ValidationException {
        // Checking if Name is 2 or More Characters
        if (App.validator.validateString(name, "Name")) {
            this.name = name;
        }
        
        // Converting Age to integer then Validating if it is above 0
        int intAge = App.validator.convertToInteger(age, "Age");
        if (App.validator.validateInt(intAge, "Age")) {
            this.age = intAge;
        }
        
        // Checking if Colour is 2 or more Characters - In proper Application would have a list of valid colours to check
        if (App.validator.validateString(colour, "Colour")) {
            this.colour = colour;
        }
        
        // Checking if Species is 2 or more Characters - In proper Application would have list of valid Species
        if (App.validator.validateString(species, "Species")) {
            this.species = species;
        }
        this.owner = id;
    }   
    /**
     * Returns Animal name
     * 
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Allows changing of the Animal name
     * 
     * @param input Type String
     * 
     * @throws ValidationException
     */
    public void setName(String input) throws ValidationException {
        if (App.validator.validateString(input, "Name")) {
            this.name = input;
        }
    }
    
    /**
     * Returns the age of Animal
     * 
     * @return age
     */
    public int getAge() {
        return this.age;
    }
    
    /**
     * Allows Changing of Animal age
     * 
     * @param input Type Integer
     * 
     * @throws ValidationException
     */
    public void setAge(String input) throws ValidationException {
        int intAge = App.validator.convertToInteger(input, "Age");
            if (App.validator.validateInt(intAge, "Age")) {
                this.age = intAge;
            }
    }
    
    /**
     * Returns colour of Animal
     * 
     * @return colour
     */
    public String getColour() {
        return this.colour;
    }
    
    /**
     * Allows changing of Animal colour
     * 
     * @param input Type String
     * 
     * @throws ValidationException 
     */
    public void setColour(String input) throws ValidationException {
        if (App.validator.validateString(input, "Colour")) {
            this.colour = input;
        }
    }
    
    /**
     * Returns species of Animal
     * 
     * @return species
     */
    public String getSpecies() {
        return this.species;
    }
    
    /**
     * Allows changing of Animal species
     * 
     * @param input Type String
     * 
     * @throws ValidationException 
     */
    public void setSpecies(String input) throws ValidationException {
        if (App.validator.validateString(input, "Species")) {
            this.species = input;
        }
    }
    
    /**
     * Uses Map to find and return Owner of animal
     * 
     * @return owner
     * 
     * @throws OwnerNotFoundException
     */
    public Object getOwner() throws OwnerNotFoundException {
        Map<Integer, Object> ownerMap = new HashMap<>();

        List<Tuple<Integer, Animal>> owners = App.openClinic.getOwners();

        // Add All Owners to the OwnerMap - (Using HashMap for Faster retrieval of Data)
        for (Tuple<Integer, Animal> tuple : owners) {
            ownerMap.put(tuple.getKey(), tuple.getValue());
        }

        // Retrieve the owner using the stored owner ID
        Object owner = ownerMap.get(this.owner);
        if (owner == null) {
            // Handle case where owner ID is not found
            throw new OwnerNotFoundException("Owner not found for HousePet ID: " + this.owner);
        }
        return owner;
    }
}