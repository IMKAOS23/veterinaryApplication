/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.classes;

/**
 *
 * @author markc
 */
public abstract class Animal {
    private String name;
    private int age;
    private String colour;
    private String species;
    private String breed;
    
    public void getName() {
        System.out.println(this.name);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void getAge() {
        System.out.println(this.age);
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void getColour() {
        System.out.println(this.colour);
    }
    
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public void getSpecies() {
        System.out.println(this.species);
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
    
    public void getBreed() {
        System.out.println(this.breed);
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
    }
}
