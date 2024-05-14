package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;
/**
 * ExoticAnimal Class
 * Used to create Exotic Animal Objects
 * 
 * @author markc
 */
public class ExoticAnimal extends Animal{
    /**
     *
     */
    
    /**
     * Constructs a new ExoticAnimal with specified name, age, colour, species, owner
     * Use either PetOwner or Farm type
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * @param id
     * 
     * @throws ValidationException 
     * @throws IllegalArgumentException if type of owner is not PetOwner or Farm
     */
    public ExoticAnimal(String name, String age, String colour, String species, int id) throws ValidationException, IllegalArgumentException {
        super(name, age, colour, species, id);
    }
}
