package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.components.business.Farm;
import com.mycompany.veterinaryApplication.components.person.PetOwner;

/**
 * HousePet class
 * Used to create HousePet objects
 * One of the Reasons separated to different objects even though functionality is nearly identical is easier
 * to sort if objects are of different types
 * 
 * @author markc
 */
public class HousePet extends Animal {
    /**
     * 
     */
    private Object owner;
    
    
    /**
     * 
     * Constructs a new HousePet with the specified name, age, colour, species and owner
     * Uses either PetOwner or Farm as owners of the Animal
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * @param owner 
     * 
     * @throws IllegalArgumentException if owner is not of type PetOwner or Farm
     */
    public HousePet(String name, int age, String colour, String species, Object owner) {
        super(name, age, colour, species);
        if (owner instanceof PetOwner || owner instanceof Farm) {
            this.owner = owner;

        } else {
            throw new IllegalArgumentException("Type Error: Owner must be of type PetOwner or Farm");
        }
    }
        
    /**
     * Returns the Owner of the House Pet
     * 
     * @return owner
     */
    public Object getOwner() {
        return this.owner;
    }
    
    /**
     * Allows changing of HousePet owner
     * 
     * @param owner 
     * 
     * @throws IllegalArgumentException if owner is not of type PetOwner or Farm
     */
    public void setOwner(Object owner) {
        if (owner instanceof PetOwner || owner instanceof Farm) {
            this.owner = owner;
        } else {
            throw new IllegalArgumentException("Type Error: Owner must be of type PetOwner or Farm");
            // Show Error Message - "Failed to change Owner of HousePet, Owner must be of type PetOwner or Farm"
        }
    }
}
