/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.components.business.Farm;
import com.mycompany.veterinaryApplication.components.person.PetOwner;
import java.util.HashMap;

/**
 *
 * @author markc
 */
public class ExoticAnimal extends Animal{
    /**
     * To-do
     * - Allow the creation of ExoticAnimal objects
     * - Appointments going to be a List of Ids linking to Appointments HashMap in Clinic, Basically a Pointer.
     */
    private Object owner;
    private HashMap appointments;
    
    // As a Normal Pet Owner and Farms could house these Exotic Animals
    // Overloading the constructor to create based upon what is inputted
    public ExoticAnimal(String name, int age, String colour, String species) {
        super(name, age, colour, species);
    }
    
    public ExoticAnimal(String name, int age, String colour, String species, boolean isFarm) {
        super(name, age, colour, species);
        owner = new Farm();
    }
}
