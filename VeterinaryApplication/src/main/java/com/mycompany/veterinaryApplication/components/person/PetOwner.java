/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.person;

import static com.mycompany.veterinaryApplication.App.validator;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pet Owner Class
 * Allows the creation of Pet Owner Objects
 * 
 * @author markc
 */
public class PetOwner extends Person{
    private final List<Integer> pets;
    
    /**
     * Constructs PetOwner object using specified First Name, Last Name, age, Email, Phone Number and Address details
     * 
     * @param firstName
     * @param lastName
     * @param age
     * @param email - Must be a valid email format such as "example@example.com"
     * @param phoneNumber - Must be valid UK phone number format such as 07333444555
     * @param houseNumber
     * @param streetName
     * @param postcode
     * @param city
     * 
     * @throws ValidationException
     * 
     */
    public PetOwner(String firstName, String lastName, String age, String email, String phoneNumber, String houseNumber, String streetName, String postcode, String city) throws ValidationException {
        super(firstName, lastName, age, email, phoneNumber, houseNumber, streetName, postcode, city);
        this.pets = new ArrayList<>();
    }
    
    /**
     * Returns Owners Pets as a List of Ids
     * Would be used to Link pets to Owner - 1 to Many relationship
     * 
     * @return List of pets
     */
    public List getPets() {
        return this.pets;
    }
}