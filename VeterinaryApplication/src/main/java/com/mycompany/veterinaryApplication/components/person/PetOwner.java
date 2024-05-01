/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markc
 */
public class PetOwner extends Person{
    private final List animals;
    
    public PetOwner(String firstName, String lastName, int age, String phoneNumber, int houseNumber, String streetName, String postcode) {
        super(firstName, lastName, age, phoneNumber, houseNumber, streetName, postcode);
        this.animals = new ArrayList();
    }
}
