/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;

/**
 *
 * @author markc
 */
public class OwnerInfo {
    private int id;
    private String identifier; // Either Email or Business/Farm Name

    /**
     * Constructor creates an OwnerInfo object to be used within a ComboBox
     * 
     * @param id
     * @param identifier 
     */
    public OwnerInfo(int id, String identifier) {
        this.id = id;
        this.identifier = identifier;
    }

    /**
     * Getter for the ID of the OwnerInfo
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the Identifier of the OwnerInfo. Usually an Email or Business Name
     * @return 
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Method overwrites the toString method of the String class to change what is found within the ComboBox.
     * This then changes what is written with the ComboBox. In this case to the Identifier that is the Email or Business Name
     * 
     * @return identifier
     */
    @Override
    public String toString() {
        return identifier;
    }
}
