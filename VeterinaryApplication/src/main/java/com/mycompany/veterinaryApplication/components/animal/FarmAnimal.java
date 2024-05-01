/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

/**
 *
 * @author markc
 */
public class FarmAnimal extends Animal{
    /**
     * 
     * @param name
     * @param age
     * @param colour
     * @param species
     * 
     * To-Do
     * - Allow Creation of FarmAnimal Objects
     * - Figure out the differences between FarmAnimals and HousePets other than Just being easier to Sort
     */
    
    // Overloading Constructor as can be found by standard Pet Owners or Farms
    public FarmAnimal(String name, int age, String colour, String species) {
        super(name, age, colour, species);
    }
    
}
