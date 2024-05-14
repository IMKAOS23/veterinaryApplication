/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;


import com.mycompany.veterinaryApplication.exceptions.ValidationException;

/**
 * Farm Animal Class
 * Allows the creation of FarmAnimal objects
 * Farm animals only can be associated with a Farm and would have specialised Vets
 * 
 * @author markc
 */
public class FarmAnimal extends Animal{
    private int owner;
    
    /**
     * Constructs a ZooAnimal object with specified name, age, colour, species and owner
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * @param id
     * 
     * @throws ValidationException
     * @throws IllegalArgumentException
     * 
     */
    public FarmAnimal(String name, String age, String colour, String species, int id) throws ValidationException, IllegalArgumentException {
        super(name, age, colour, species, id);
    }
}
