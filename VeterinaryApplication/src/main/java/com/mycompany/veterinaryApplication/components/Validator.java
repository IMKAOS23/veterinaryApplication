/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;

import java.util.Map;

/**
 *
 * @author markc
 */

// Class to be used to house all validation functions
public class Validator {
    
    // Used to retrieve the highest key within the Map
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
}
