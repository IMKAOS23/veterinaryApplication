package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.Tuple;
import com.mycompany.veterinaryApplication.exceptions.OwnerNotFoundException;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param id 
     * 
     * @throws ValidationException 
     */
    public HousePet(String name, String age, String colour, String species, int id) throws ValidationException {
        super(name, age, colour, species, id);
    }
}
