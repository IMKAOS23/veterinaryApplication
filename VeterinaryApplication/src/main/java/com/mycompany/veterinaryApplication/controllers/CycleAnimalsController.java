package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.animal.Animal;
import com.mycompany.veterinaryApplication.components.business.Farm;
import com.mycompany.veterinaryApplication.components.business.Zoo;
import com.mycompany.veterinaryApplication.components.person.PetOwner;
import com.mycompany.veterinaryApplication.exceptions.NotFoundException;
import com.mycompany.veterinaryApplication.exceptions.OwnerNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CycleAnimalsController {

    @FXML
    private Label titleLabel;
    
    @FXML
    private Label nameOfAnimal;
    
    @FXML
    private Label ageOfAnimal;
    
    @FXML
    private Label colourOfAnimal;
    
    @FXML
    private Label speciesOfAnimal;
    
    @FXML
    private Label ownerOfAnimal;
    
    public void initialize() throws NotFoundException, IOException, OwnerNotFoundException {
        try {
            Animal animal = App.openClinic.findAnimal(App.currentId);
            displayValues(animal);
            
        } catch (NotFoundException e) {
            App.popup.showMessage("Could Not Find Animal", "Could Not Find Animal in Clinic");
            App.setRoot("MainMenu");
        }
    }
    
    private void displayValues(Animal animal) throws OwnerNotFoundException, IOException {
        titleLabel.setText(String.valueOf("Animal ID - " + App.currentId));
        nameOfAnimal.setText(animal.getName());
        ageOfAnimal.setText(String.valueOf(animal.getAge()));
        colourOfAnimal.setText(animal.getColour());
        speciesOfAnimal.setText(animal.getSpecies());
        
        try {
            Object objOwner = animal.getOwner();
            if (objOwner instanceof PetOwner) {
                PetOwner owner = (PetOwner) objOwner;
                ownerOfAnimal.setText(owner.getEmail());
            } else if (objOwner instanceof Farm) {
                Farm owner = (Farm) objOwner;
                ownerOfAnimal.setText(owner.getName());
            } else {
                Zoo owner = (Zoo) objOwner;
                ownerOfAnimal.setText(owner.getName());
            }
        } catch (OwnerNotFoundException e) {
            App.popup.showError("Owner not Found", "Could not find owner");
        }
    }
    
    @FXML
    private void goBack() throws IOException {
        App.setRoot("MainMenu");
    }
    
    
    @FXML
    private void nextAnimal() {
        App.currentId++; 
        try {
            int totalAnimals = App.openClinic.getAnimals().size();
            if (App.currentId > totalAnimals) {
                App.currentId = 1;
            }
            initialize(); // Calling intialize rests page with new Values
            // Catching any Exception
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Inverse of nextAnimal
    @FXML
    private void prevAnimal() {
        App.currentId--;
        try {
            if (App.currentId < 1) {
                App.currentId = 1;
            }
            initialize(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}