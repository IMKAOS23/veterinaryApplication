/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components.person;

/**
 *
 * @author markc
 */
public class Vet extends Person{
    private String specialty;
    
    public Vet(String firstName, String lastName, int age, String phoneNumber, int houseNumber, String streetName, String postcode, String specialty) {
        super(firstName, lastName, age, phoneNumber, houseNumber, streetName, postcode);
        this.specialty = specialty;
    }
    
}
