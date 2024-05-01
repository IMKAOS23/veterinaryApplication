/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.animal;

import java.io.Serializable;

/**
 *
 * @author markc
 */
public abstract class Animal implements Serializable{
    private String name;
    private int age;
    private String colour;
    private String species;
    
    public Animal(String name, int age, String colour, String species) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.species = species;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getColour() {
        return this.colour;
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getSpecies() {
        return this.species;
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
}