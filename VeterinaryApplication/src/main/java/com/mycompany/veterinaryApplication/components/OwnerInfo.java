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

    public OwnerInfo(int id, String identifier) {
        this.id = id;
        this.identifier = identifier;
    }

    public int getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    // Overriding the ComboBox toString method this will only show indentifier instead of object.
    // This is an Email for Pet Owner or Vet
    // And Name of Business for Business
    @Override
    public String toString() {
        return identifier;
    }
}
