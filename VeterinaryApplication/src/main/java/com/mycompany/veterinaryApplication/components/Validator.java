/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.time.LocalDate;
import java.time.Month;
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
    /**
     * Method for Validating the Selected file as something derived from the Clinic Class
     * 
     * @param obj
     * 
     * @return boolean
     * 
     * @throws ValidationException 
     */
    public boolean validateClinic(Object obj) throws ValidationException {
        if (obj instanceof Clinic) {
            return true;
        } else { 
            throw new ValidationException("Validation Error: Object is not of type Clinic");
        }
    }
    
    public boolean validateClinicName(String input) throws ValidationException {
        if (input.trim().length() >= 8) {
            return true;
        } else {
            throw new ValidationException("Validation Error: Clinic name must be 8 or more characters long");
        }
    }
    
    /**
     * Returns true if String input is more than Characters without spaces
     * 
     * @param input - Input to Validate
     * @param name - What the input is. Example - Name, City, Etc
     * 
     * @return boolean
     * 
     * @throws ValidationException
     */
    public boolean validateString(String input, String name) throws ValidationException {
        if (input.trim().length() >= 2) {
            return true;
        } else {
            throw new ValidationException("Validation Error: " + name + " must be more than 2 characters");
        }
    }
    
    
    /**
     * Returns true if int input is greater than or equal to 0
     * 
     * @param input - What to Validate
     * @param name - What is the input. Example - An Age.
     * 
     * @return boolean
     * 
     * @throws ValidationException
     */
    public boolean validateInt(int input, String name) throws ValidationException {
        if (input >= 0) {
            return true;
        } else {
            throw new ValidationException("Validation Error: " + name + " must be greater than 0");
        }
    }
    
    /**
     * Returns true if Date is less than current date and greater than Jan 1st 1990
     * 
     * @param input
     * 
     * @return boolean
     * 
     * @throws ValidationException
     */
    public boolean validateDate(LocalDate input) throws ValidationException {
        LocalDate currentDate = LocalDate.now();
        LocalDate janFirst1990 = LocalDate.of(1990, Month.JANUARY, 1);
        
        if (!(input.isBefore(janFirst1990) && !input.isAfter(currentDate))) {
            return true;
        } else {
            throw new ValidationException("Validation Error: Date invalid. Must be Before Current Date and After Jan 1st 1900");
        }
    }
    
    /**
     * Returns true if postcode input matches the Reg Expression for a UK Style postcode
     * 
     * @param input
     * 
     * @return boolean
     * 
     * @throws ValidationException
     */
    public boolean validatePostcode(String input) throws ValidationException {
        String regExpression = "^[A-Z]{1,2}[0-9]{1,2}[0-9A-Z]? [0-9][A-Z]{2}$";
        Pattern pattern = Pattern.compile(regExpression);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            return true;
        } else {
            throw new ValidationException("Validation Error: Postcode is not of UK format");
        }
    }
    
    /**
     * Returns true if email is a valid email (if email is like example@email.com)
     * 
     * @param input
     * 
     * @return boolean
     * 
     * @throws ValidationException 
     */
    public boolean validateEmail(String input) throws ValidationException {
        String regExpression = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regExpression);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            return true;
        } else {
            throw new ValidationException("Validation Error: Email is not valid");
        }
    }
    
    /**
     * Returns true if phone number is a valid phone (07333444555 - 01613334444)
     * 
     * @param input
     * 
     * @return boolean
     * 
     * @throws ValidationException 
     */
    public boolean validatePhone(String input) throws ValidationException {
        String regExpression = "^07[0-9]{9}|0161[0-9]{7}$";
        Pattern pattern = Pattern.compile(regExpression);
        Matcher matcher = pattern.matcher(input);
        
        if (matcher.find()) {
            return true;
        } else {
            throw new ValidationException("Validation Error: Phone Number not Valid");
        }
    }
    
    /**
     * Returns an Integer or null as long as able to convert String -> Integer
     * 
     * @param input - String to Convert
     * @param name - Title of Value such as "Age" - To be used in Error
     * 
     * @return Integer | null
     * 
     * @throws ValidationException
     */
    public Integer convertToInteger(String input, String name) throws ValidationException {
        try {
            Integer newInt = Integer.valueOf(input);
            return newInt;
        } catch (NumberFormatException e) {
            throw new ValidationException("Conversion Error: " + name + " could not be converted to type Integer");
        }
    }
}
