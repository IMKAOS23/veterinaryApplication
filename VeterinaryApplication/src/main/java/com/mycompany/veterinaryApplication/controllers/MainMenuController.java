package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.FileHandler;
import com.mycompany.veterinaryApplication.components.Clinic;
import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class MainMenuController { 
    private final FileHandler fileHandler = new FileHandler();
    
    @FXML 
    private Button btnOpenClinic;
    
    @FXML
    private Label clinicOpen;
    
    @FXML
    private Label placeholderText;
    
    public void initialize() {
        if (App.openClinic != null) {
            clinicOpen.setText("Clinic Name: " + App.openClinic.getName());
        }
    }
    
    @FXML
    private void submitSearch() throws IOException {
        if (App.openClinic == null) { 
            App.popup.showError("Clinic not open", "Open a Clinic before trying to search for an Animal");
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
            App.popup.showError("Clinic not open", "Open a Clinic before trying to add an Animal");
        }
        else {
            App.popup.showWindow("Choose Animal Type", "CreateAnimalPopup");
        }
    }
    
    @FXML
    private void createPerson() throws IOException {
        // Should open dialog with different type of People - Pet Owners or Vetenarians)
        if (App.openClinic == null) {
            App.popup.showError("Clinic not open", "Open a Clinic before trying to add a Person");
        }
        else {
            App.popup.showWindow("Choose Person Type", "CreatePersonPopup");
        }
    }
    
    @FXML
    private void createBusiness() throws IOException {
        // Should open dialog with different type of Businesses - Zoos, Farms
        if (App.openClinic == null) {
            App.popup.showError("Clinic not open", "Open a Clinic before trying to add a business");
        }
        else {
            App.popup.showWindow("Choose Business Type", "CreateBusinessPopup");
        }
    }
    
    @FXML
    private void createAppointment() throws IOException {
        // opens the Appointment creator allowing User to select a Pet, Date and Time and have a Vet Selected (Might not be auto-selected)
        if (App.openClinic == null) {
            App.popup.showError("Clinic not open", "Open a Clinic before trying to book an appointment");
        }
        else {
            App.setRoot("createAppointment");
            
        }
    }
    
    @FXML
    private void createClinic() throws IOException {
        // Method used to Create a Basic Clinic - Would open Dialog asking for a little information such as Name
        String clinicName = App.popup.showTextInput("Create Clinic", "Enter A Clinic Name", "Clinic Name: ");
        
        if ("32323423423422".equals(clinicName)) {
            System.out.println("Cancelled out");
            
        } else if (clinicName != null) {
            if (App.validator.validateClinicName(clinicName)) {
                Clinic clinic = new Clinic(clinicName);
                App.openClinic = clinic;
                clinicOpen.setText("Clinic Name: " + App.openClinic.getName());
            } else {
                App.popup.showError("Could Not Create Clinic", "Clinic name must be more than 8 characters");
            }
        } else {
            App.popup.showError("Could Not Create Clinic", "Clinic must have a name");
        }
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
            boolean result = App.popup.showConfirm("Are you sure?", "Are you sure you want to close Clinic?");
            if (result == true) {
                App.openClinic = null;
                clinicOpen.setText("Clinic Name: None");
                App.popup.ShowMessage("Closed Clinic", "Clinic Successfully closed");
            } else {
                App.popup.ShowMessage("Clinic not Closed", "Clinic was not closed");
            }
        } else {
        // Alert User that no Clinic is Open
        App.popup.showError("Cannot close Clinic", "No Clinic Open");
        }
    }
}