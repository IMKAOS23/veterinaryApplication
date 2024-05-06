/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import com.mycompany.veterinaryApplication.components.business.Zoo;

/**
 * Zoo Animal Class
 * Allows creation of ZooAnimal objects
 * Zoo Animals like farm animals can only be associated with a Zoo and would have Specialised Vets
 * 
 * @author markc
 */
public class ZooAnimal extends Animal{
    private Zoo owner;
    /**
     * Constructs ZooAnimal objects with specified name, age, colour, species and owner
     * 
     * @param name
     * @param age
     * @param colour
     * @param species 
     * @param owner
     * 
     */
    public ZooAnimal(String name, int age, String colour, String species, Zoo owner) {
        super(name, age, colour, species);
        this.owner = owner;
    }
    
    /**
     * Returns the owner of the Zoo Animal
     * 
     * @return owner 
     */
    public Zoo getOwner() {
        return this.owner;
    }
    
    /**
     * Allows the changing of ZooAnimal owner
     * 
     * @param owner 
     */
    public void setOwner(Zoo owner) {
        this.owner = owner;
    }
}
