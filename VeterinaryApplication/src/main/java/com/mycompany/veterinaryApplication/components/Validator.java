/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.App;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validator Class
 * Used to perform validation of certain aspects of code
 * 
 * @author markc
 */

// Class to be used to house all validation functions
public class Validator {
    
    // Used to find Highest key within an array of Tuples
    // Need to rework to work with ArrayLists and Tuples
    public Integer findHighestKey(Map<Integer, ?> map) {
        int highestKey = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (key > highestKey){
                highestKey = key;
            }
        }
        return highestKey;
    }
    // Method for Validating the Selected file as something derived from the Clinic Class
    public boolean validateClinic(Object obj) {
        return obj instanceof Clinic;
    }
    
    public boolean validateClinicName(String input) {
        return input.trim().length() > 8;
    }
    
    /**
     * Returns true if name input is more than Characters without spaces
     * 
     * @param input
     * @return boolean
     * 
     */
    public boolean validateName(String input) {
        return input.trim().length() >= 2;
    }
    
    
    /**
     * Returns true if int input is greater than or equal to 0
     * 
     * @param input
     * @return boolean
     */
    public boolean validateInt(int input) {
        return (input >= 0);
    }
    
    /**
     * Returns true if Pet ID input is greater than or equal to 2 and greater than lastAnimalId of Clinic
     * 
     * @param input
     * @return boolean
     */
    public boolean validatePetId(int input) {
        int lastAnimalId = App.openClinic.getLastAnimalId();
        return input >= 0 && input <= lastAnimalId;
    }
    
    /**
     * Returns true if postcode input matches the Reg Expression for a UK Style postcode
     * 
     * @param input
     * @return boolean
     */
    public boolean validatePostcode(String input) {
        String regExpression = "^[A-Z]{1,2}[0-9]{1,2}[0-9A-Z]? [0-9][A-Z]{2}$";
        Pattern pattern = Pattern.compile(regExpression);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}
