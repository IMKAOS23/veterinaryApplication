/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.Showable;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Animal Class - Abstract Class that implements the Serializable interface to allow the serialization of objects
 * which inherit from the Animal class
 * 
 * Sets up the Basic Functionality of Animals such as Name, Age, Colour, Species, Appointment List
 * 
 * @author markc
 */
public abstract class Animal implements Showable, Serializable{
    private String name;
    private int age;
    private String colour;
    private String species;
    private List appointments;
    
    /**
     * Constructs a basic Animal object, called using super() method in a subclasses constructor
     * 
     * @param name
     * @param age
     * @param colour
     * @param species 
     */
    public Animal(String name, int age, String colour, String species) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.species = species;
        this.appointments = new ArrayList();
    }
    
    @Override
    public void addToShowList() {
        
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
     * @throws ValidationException if validation of name fails
     */
    public void setName(String input) throws ValidationException {
        if (!App.validator.validateName(input)) {
            throw new ValidationException("Validation Error: Name must be more than 2 characters in length");
        }
        this.name = input;
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
     * @throws ValidationException if type is not Integer or Validation from 
     */
    public void setAge(String input) throws ValidationException {
        try {
            int age = Integer.parseInt(input);
            
            if (!App.validator.validateInt(age)) {
                throw new ValidationException("Validation Error: Age must be above 0");
            }
            this.age = age;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Type Error: Age must be of Type Int");
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
     * Does not Require Type checking like others due to how it is chose using a ChoiceBox
     * 
     * @param colour 
     */
    public void setColour(String colour) {
        this.colour = colour;
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
     * Does not require Type checking like others due to how it is chose using a ChoiceBox
     * @param species 
     */
    public void setSpecies(String species) {
        this.species = species;
    }
    
    /**
     * Returns the list of appointments
     * Appointments are of type Tuple.
     * 
     * @return appointments list
     */
    public List getAppointmentList() {
        return this.appointments;
    }
    
    // To be created
    public void addAppointment() {
        // Create Appointment
    }
}