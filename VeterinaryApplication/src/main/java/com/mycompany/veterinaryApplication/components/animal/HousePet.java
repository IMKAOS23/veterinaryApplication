package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.components.person.PetOwner;

/**
 *
 * @author markc
 */
public class HousePet extends Animal {
    /**
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * @param petOwner 
     * 
     * To-do
     * - Allow creation of HousePet Objects
     * - Link HousePet to an Owner.
     */
    
    // Refers Specifically to being a "house pet"
    public HousePet(String name, int age, String colour, String species, PetOwner petOwner) {
        super(name, age, colour, species);
    }
}
