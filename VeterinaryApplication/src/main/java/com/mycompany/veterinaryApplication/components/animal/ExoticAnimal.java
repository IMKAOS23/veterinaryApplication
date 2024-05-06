package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.components.business.Farm;
import com.mycompany.veterinaryApplication.components.person.PetOwner;

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
    private Object owner;
    
    /**
     * Constructs a new ExoticAnimal with specified name, age, colour, species, owner
     * Use either PetOwner or Farm type
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * @param owner 
     * 
     * @throws IllegalArgumentException if type of owner is not PetOwner or Farm
     */
    public ExoticAnimal(String name, int age, String colour, String species, Object owner) {
        super(name, age, colour, species);
        if (owner instanceof PetOwner || owner instanceof Farm) { 
            this.owner = owner;
        } else {
            throw new IllegalArgumentException("Type Error: Owner must be of type PetOwner or Farm");
        }
    }
    
    /**
     * Returns Owner of animal
     * 
     * @return owner
     */
    public Object getOwner() {
        return this.owner;
    }
    
    /**
     * Allows the changing of ExoticAnimal owner
     *
     * @param owner 
     * 
     * @throws IllegalArgumentException if type is not PetOwner or Farm
     */
    public void setOwner(Object owner) {
        if (owner instanceof PetOwner || owner instanceof Farm) {
            this.owner = owner;
        } else {
            throw new IllegalArgumentException("Type Error: Owner must be of type PetOwner or Farm");
        }
    }
}
