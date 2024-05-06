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
     * Constructs PetOwner object using specified First Name, Last Name, age, Email, Phone Number, House Number,
     * Street Name, Postcode
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
     * 
     */
    public PetOwner(String firstName, String lastName, int age, String email, String phoneNumber, int houseNumber, String streetName, String postcode) throws ValidationException {
        super(firstName, lastName, age, email, phoneNumber, houseNumber, streetName, postcode);
        this.pets = new ArrayList<>();
    }
    
    /**
     * Returns Owners Pets as a List of Ids
     * 
     * @return List of pets
     */
    public List getPets() {
        return this.pets;
    }
    
    /**
     * Takes in an Id and adds it to the Pets list
     * Would be used when specially adding Pet to Owner or Adding pet directly to owner via taking the newly generated lastPetId from clinic
     * @param id 
     * 
     * @throws ValidationException if inputted ID is below 0 and above the LastInsertedID
     */
    public void addPet(int id) throws ValidationException {
        if (validator.validatePetId(id)) {
            this.pets.add(id);
        } else {
            throw new ValidationException("Validation Error: No such ID exists");
        }
    }
    
    /**
     * Takes in an Animal Id and removes it from the list if found
     * 
     * @param id
     * 
     */
    public void removePet(int id) {
        for (int x=0; x<this.pets.size(); x++) {
            if (this.pets.get(x) == id) {
                this.pets.remove(x);
                return;
            }
        }
    }
}
