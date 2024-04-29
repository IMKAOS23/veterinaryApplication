/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
public class FileHandler {
    
    // Method for Serialising a Class in the case of the application the "Clinic" Class is to be serialised
    public void serialise(String filename) {
        filename = filename + ".txt";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            System.out.println("Data Saved to " + filename);
        }  
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Method for DeSerialising a File to an Object to be used throughout the application
    public void deserialiseFile() {
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
    
    // Method for Validating the Selected file as something derived from the Clinic Class
    private boolean validateFile() {
        return true;
    }
}