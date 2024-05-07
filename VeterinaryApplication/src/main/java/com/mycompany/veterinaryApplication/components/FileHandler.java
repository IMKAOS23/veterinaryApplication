/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;
     
import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author markc
 */

// Purpose Built Class for Handling Files. 
// Encapsulation - Only have methods of Same type in each class
// Single Responsiblity Principle - Only File Handling Methods
public class FileHandler {
    Validator validator = new Validator();
    
    // Method for Serialising a Class in the case of the application the "Clinic" Class is to be serialised
    public void serialise(String filename, Clinic clinic) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename + ".dat"); // Creating FileOutputStream - How to Save to File
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) { // Creating ObjectOutputStream - How to get object
            objectOut.writeObject(clinic); // Writing object to ObjectOutputStream which then gets saved to FileOutputStream in turn A file.
        }  
        catch (IOException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
    
    // Method for DeSerialising a File to an Object to be used throughout the application
    public Clinic deserialiseFile(String filePath) throws IOException, ClassNotFoundException, ValidationException {
        try (FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
            Object obj = objIn.readObject();
            if (validator.validateClinic(obj)) {
                Clinic clinic = (Clinic) obj;
                App.popup.showMessage("Successfully Opened Clinic", "Successfully opened Clinic - " + clinic.getName());
                return (Clinic) obj;
            } else {
                App.popup.showError("Error", "File Error: File is not a Clinic");
                return null;
            }
        }
        catch (IOException e) {
            App.popup.showError("Error", "Deserialization Error: Failed to Deserialize File");
            return null;
        }
    }
    
    // Method for Opening a File Selector Dialog Box which allows you to select a file
    public File openFileSelector(String titleString, Button openFileButton, String fileType, String fileExtension) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(titleString);
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter(fileType, fileExtension),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        Stage stage = (Stage) openFileButton.getScene().getWindow();
        return fileChooser.showOpenDialog(stage);
    }
    
    
    // Probably not going to be implemented due to time constraints
    // Transactions as Serialising constantly is resource intensive
    public void beginTransaction() {
        
    }
    
    // This will Commit the changes to the .dat file using the .txt unserialised file while saving the past obj to be used for rollback
    public void commitTransaction() {
        
    }
    
    // This will use the .txt file to rollback the commit
    public void rollbackTransaction() {
        
    }
}
