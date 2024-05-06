/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.person;

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
     * 
     * 
     * @param firstName
     * @param lastName
     * @param age
     * @param email
     * @param phoneNumber
     * @param houseNumber
     * @param streetName
     * @param postcode
     * @param specialty
     * 
     * @throws ValidationException 
     */
    public Vet(String firstName, String lastName, int age, String email, String phoneNumber, int houseNumber, String streetName, String postcode, String specialty) throws ValidationException {
        super(firstName, lastName, age, email, phoneNumber, houseNumber, streetName, postcode);
        this.specialty = specialty;
        this.daysWorking = new ArrayList<>();
    }
    
    public String getSpecialty() {
        return this.specialty;
    }
    
    // Create a validation method for checking if string is either (House Pet, Exotic Animal, Farm Animal, Zoo Animal)
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    
    // Create method to add a Day to daysWorking List
    
    // Create method to remove a Day from daysWorking List
}
