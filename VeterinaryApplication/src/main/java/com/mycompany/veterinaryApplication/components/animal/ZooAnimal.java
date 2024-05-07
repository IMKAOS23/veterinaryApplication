/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.exceptions.OwnerNotFoundException;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;

/**
 * Zoo Animal Class
 * Allows creation of ZooAnimal objects
 * Zoo Animals like farm animals can only be associated with a Zoo and would have Specialised Vets
 * 
 * @author markc
 */
public class ZooAnimal extends Animal{
    /**
     * Constructs ZooAnimal objects with specified name, age, colour, species and owner
     * 
     * @param name
     * @param age
     * @param colour
     * @param species 
     * @param id
     * 
     * @throws ValidationException
     * @throws IllegalArgumentException
     * @throws OwnerNotFoundException
     * 
     */
    public ZooAnimal(String name, String age, String colour, String species, int id) throws ValidationException, IllegalArgumentException {
        super(name, age, colour, species, id);
    }
}