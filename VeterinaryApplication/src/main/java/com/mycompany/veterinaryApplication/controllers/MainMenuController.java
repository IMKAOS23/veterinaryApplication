package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.FileHandler;
import com.mycompany.veterinaryApplication.components.Clinic;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Popup;


public class MainMenuController { 
    private final FileHandler fileHandler = new FileHandler();
    
    @FXML 
    private Button btnOpenClinic;
    
    @FXML
    private Label clinicOpen;
    
    @FXML
    private Label placeholderText;
    
    @FXML
    private void submitSearch() throws IOException {
        if (App.openClinic == null) { 
            System.out.println("Open a Clinic before Searching for an Animal");
        } else {
            System.out.println("Found Pet!");
        }
    }
    
    @FXML
    private void createAnimal() throws IOException {
        // First to be done
        // Should open dialog with different type of Animals - House Pet, Farm Animal, Zoo Animal, Exotic Animal
        if (App.openClinic == null) {
            // Alert User they need to open a clinic first
            System.out.println("Open a Clinic before Adding an Animal");
        }
        else {
            App.setRoot("AddAnimalState");
        }
    }
    
    @FXML
    private void createPerson() throws IOException {
        // Should open dialog with different type of People - Pet Owners, Vetenarians, Business Owners (Maybe wont do, or might only be in createBusiness)
        if (App.openClinic == null) {
            System.out.println("Open a Clinic Before Adding a Vet");
        }
        else {
            System.out.println("Added Vet");
        }
    }
    
    @FXML
    private void createBusiness() throws IOException {
        // Should open dialog with different type of Businesses - Zoos, Farms
        if (App.openClinic == null) {
            System.out.println("Open a Clinic Before Adding an Pet Owner");
        }
        else {
            System.out.println("Added Pet Owner");
        }
    }
    
    @FXML
    private void createAppointment() throws IOException {
        // opens the Appointment creator allowing User to select a Pet, Date and Time and have a Vet Selected (Might not be auto-selected)
        if (App.openClinic == null) {
            System.out.println("Open a Clinic Before Adding a Zoo");
        }
        else {
            System.out.println("Added Zoo");
        }
    }
    
    @FXML
    private void createClinic() throws IOException {
        // Method used to Create a Basic Clinic - Would open Dialog asking for a little information such as Name
        Clinic clinic = new Clinic("Freds Veterinary Surgery");
        App.openClinic = clinic;
        // Show User they sucessfully created a clinic
    }
    
    @FXML
    private void openClinic() throws IOException, ClassNotFoundException{
        // Almost Completed
        File selectedFile = fileHandler.openFileSelector("Select a Valid Clinic File", btnOpenClinic, "Text Files", "*.txt");
        
        if (selectedFile != null) {
            App.openClinic = fileHandler.deserialiseFile(selectedFile.getAbsolutePath());
            clinicOpen.setText("Clinic Name: " + App.openClinic.getName());
            // Show User they successfully opened Clinic
        }
    }
    
    @FXML
    private void closeClinic() throws IOException {
        // Sets openClinic to null and resets text to say None
        if (App.openClinic != null) {
            App.openClinic = null;
            clinicOpen.setText("Clinic Name: None");
            // Show the User they successfully closed Clinic
        } else {
            // Alert User that no Clinic is Open
        }
    }
}