/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.person;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markc
 */
public class Vet extends Person{
    // Used to select Vet Automatically in appointments
    private String specialty;
    
    // May not be used
    private List<String> daysWorking;
    
    /**
     * Constructs a Vet object with specified First Name, Last Name, Age, Email, Phone Number, Speciality and Address details
     * 
     * @param firstName
     * @param lastName
     * @param age
     * @param email
     * @param phoneNumber
     * @param houseNumber
     * @param streetName
     * @param postcode
     * @param city
     * @param speciality
     * 
     * @throws ValidationException 
     */
    public Vet(String firstName, String lastName, String age, String email, String phoneNumber, String houseNumber, String streetName, String postcode, String city, String speciality) throws ValidationException {
        super(firstName, lastName, age, email, phoneNumber, houseNumber, streetName, postcode, city);
        if (App.validator.validateString(speciality, "Speciality")) {
            this.specialty = speciality;
        }
        this.daysWorking = new ArrayList<>();
    }
    
    /**
     * Returns speciality of Vet
     * 
     * @return speciality 
     */
    public String getSpecialty() {
        return this.specialty;
    }
    
    /**
     * Allows the changing of Vet speciality
     * 
     * @param input
     * 
     * @throws ValidationException
     */
    public void setSpecialty(String input) throws ValidationException {
        if (App.validator.validateString(input, "Speciality")) {
            this.specialty = input;
        }
    }
    
    // Create method to add a Day to daysWorking List
    
    // Create method to remove a Day from daysWorking List
}
