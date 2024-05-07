package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.FileHandler;
import com.mycompany.veterinaryApplication.components.Clinic;
import com.mycompany.veterinaryApplication.components.Tuple;
import com.mycompany.veterinaryApplication.components.animal.Animal;
import com.mycompany.veterinaryApplication.exceptions.NotFoundException;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;


public class MainMenuController { 
    private final FileHandler fileHandler = new FileHandler();
    AnimalScrollPaneController controller;
    
    @FXML
    private TextField tfSearchPets;
    
    @FXML 
    private Button btnOpenClinic;
    
    @FXML
    private Label clinicOpen;
    
    @FXML
    private ScrollPane scrollPane;
    
    
    public void initialize() throws IOException {
        tfSearchPets.requestFocus();
        if (App.openClinic != null) {
            clinicOpen.setText("Clinic Name: " + App.openClinic.getName());
            AnimalScrollPaneController controller = new AnimalScrollPaneController(scrollPane);
            this.controller = controller;
            this.controller.populateScrollPane(App.openClinic.getAnimals());
        }
        
    }
    
    @FXML
    private void submitSearch() throws IOException {
        if (App.openClinic == null) { 
            App.popup.showError("Clinic not open", "Open a Clinic before trying to search for an Animal");
        } else {
            List<Tuple> searchResults = searchAnimals();
            this.controller.populateScrollPane(searchResults);
        }
    }
    
    private List searchAnimals() {
        List<Tuple> searchResults = new ArrayList<>();
        List<Tuple> animals = App.openClinic.getAnimals();
        String searchInput = tfSearchPets.getText();
        
        // Checks if Search is Empty
        if (searchInput.trim().isEmpty()) {
            App.popup.showMessage("Empty Search", "To Search Enter a Value");
            // Returns List of All Animals
            return App.openClinic.getAnimals();
        }

        for (Object objTuple : animals) {
            // As i know it is a Tuple Object i can declare it as "Tuples"
            Tuple tuple = (Tuple) objTuple;

            // As i know that only Animal Objects are in Animal List i can declare them as "Animals"
            Object objAnimal = tuple.getValue();
            Animal animal = (Animal) objAnimal;

            String animalName = animal.getName();
            if (animalName.contains(searchInput)) {
                searchResults.add(tuple);
            }
        }
        return searchResults;
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
            if (App.openClinic.getOwners().isEmpty()) {
                App.popup.showMessage("Create Owner Object", "Create an Owner object before trying to create an animal. Either: PetOwner, Farm, or Zoo");
                return;
            }
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
            App.popup.showMessage("Not Implemented", "Appointment yet not Implement");
            
        }
    }
    
    @FXML
    private void createClinic() throws IOException, ValidationException {
        // Method used to Create a Basic Clinic - Would open Dialog asking for a little information such as Name
        if (App.openClinic != null) {
            App.popup.showMessage("Clinic Already Open", "Clinic Already Open, Close Clinic to Create another Clinic");
            return;
        }
        String clinicName = App.popup.showTextInput("Create Clinic", "Enter A Clinic Name", "Clinic Name: ");
        
        if ("32323423423422".equals(clinicName)) {
            return;
        } else if (clinicName != null) {
            if (App.validator.validateClinicName(clinicName)) {
                Clinic clinic = new Clinic(clinicName);
                App.openClinic = clinic;
                clinicOpen.setText("Clinic Name: " + App.openClinic.getName());
                initialize();
            } else {
                App.popup.showError("Could Not Create Clinic", "Clinic name must be more than 8 characters");
            }
        } else {
            App.popup.showError("Could Not Create Clinic", "Clinic must have a name");
        }
        // Show User they sucessfully created a clinic
    }
    
    @FXML
    private void openClinic() throws IOException, ClassNotFoundException, ValidationException, NotFoundException {
        if (App.openClinic != null) {
           App.popup.showMessage("Clinic Already Open", "Close Clinic before trying to Open another");
        }
        
        File selectedFile = fileHandler.openFileSelector("Select a Valid Clinic File", btnOpenClinic, "Data Files", "*.dat");
        
        if (selectedFile != null) {
            App.openClinic = fileHandler.deserialiseFile(selectedFile.getAbsolutePath());
            clinicOpen.setText("Clinic Name: " + App.openClinic.getName());
            initialize();
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
                App.popup.showMessage("Closed Clinic", "Clinic Successfully closed");
            } else {
                App.popup.showMessage("Clinic not Closed", "Clinic was not closed");
            }
        } else {
        // Alert User that no Clinic is Open
        App.popup.showError("Cannot close Clinic", "No Clinic Open");
        }
    }
    
    @FXML
    private void cycleAnimals() throws IOException {
        if (App.openClinic != null) {
            if (!App.openClinic.getAnimals().isEmpty()) {
                App.currentId = 1;
                App.setRoot("CycleAnimals");
            } else {
                App.popup.showMessage("No Animals", "Add an Animal to Clinic before Cycling Animals");
            }
        } else {
            App.popup.showError("Clinic not Open", "Open a Clinic before trying to Cycle Animals");
        }
    }
    
    @FXML
    private void resetSearch() throws IOException {
        if (App.openClinic != null) {
            initialize();
        }
    }
}