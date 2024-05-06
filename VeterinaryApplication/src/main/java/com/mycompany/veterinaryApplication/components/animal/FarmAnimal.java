/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.components.business.Farm;

/**
 * Farm Animal Class
 * Allows the creation of FarmAnimal objects
 * Farm animals only can be associated with a Farm and would have specialised Vets
 * 
 * @author markc
 */
public class FarmAnimal extends Animal{
    private Farm owner;
    
    /**
     * Constructs a ZooAnimal object with specified name, age, colour, species and owner
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * @param owner
     * 
     */
    public FarmAnimal(String name, int age, String colour, String species, Farm owner) {
        super(name, age, colour, species);
        this.owner = owner;
    }
    
    /**
     * Returns the owner of the FarmAnimal
     * 
     * @return owner
     */
    public Farm getOwner() {
        return this.owner;
    }
    
    /**
     * Allows the changing of FarmAnimal owner
     * 
     * @param owner 
     */
    public void setOwner(Farm owner) {
        this.owner = owner;
    }
}