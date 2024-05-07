package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.OwnerInfo;
import com.mycompany.veterinaryApplication.components.Tuple;
import com.mycompany.veterinaryApplication.components.animal.ExoticAnimal;
import com.mycompany.veterinaryApplication.components.animal.FarmAnimal;
import com.mycompany.veterinaryApplication.components.animal.HousePet;
import com.mycompany.veterinaryApplication.components.animal.ZooAnimal;
import com.mycompany.veterinaryApplication.components.business.Farm;
import com.mycompany.veterinaryApplication.components.business.Zoo;
import com.mycompany.veterinaryApplication.components.person.PetOwner;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddAnimalController {
    private String type;
    
    @FXML
    private Label titleLabel;
    
    @FXML
    private TextField tfPetName;
    @FXML
    private TextField tfPetAge;
    @FXML
    private TextField tfPetColour;
    @FXML
    private TextField tfPetSpecies;
    @FXML
    private ComboBox selector;
    
    
    
    public void initialize() throws IOException {
        List<OwnerInfo> owners = new ArrayList();
        if (null == App.type) {
            this.goBack();
        } else switch (App.type) {
            case "housePet":
                titleLabel.setText("Add House Pet to Clinic");
                this.type = "housePet";
                for (Object tuple : App.openClinic.getOwners()) {
                    Tuple tupl = (Tuple) tuple;
                    Object person = tupl.getValue();
                    if (person instanceof PetOwner) {
                        Object key = tupl.getKey();
                        int id = (Integer) key;
                        
                        PetOwner petOwner = (PetOwner) person;
                        String identifier = petOwner.getEmail();
                        
                        OwnerInfo ownerInfo = new OwnerInfo(id, identifier);
                        owners.add(ownerInfo);
                    }
                }
                for (Object tuple : App.openClinic.getOwners()) {
                    Tuple tupl = (Tuple) tuple;
                    Object business = tupl.getValue();
                    if (business instanceof Farm) {
                        Object key = tupl.getKey();
                        int id = (Integer) key;
                        
                        Farm farm = (Farm) business;
                        String identifier = farm.getName();
                        
                        OwnerInfo ownerInfo = new OwnerInfo(id, identifier);
                        owners.add(ownerInfo);
                    }
                }
                break;
                
            case "exoticAnimal":
                titleLabel.setText("Add Exotic Animal to Clinic");
                this.type = "exoticAnimal";
                for (Object tuple : App.openClinic.getOwners()) {
                    Tuple tupl = (Tuple) tuple;
                    Object person = tupl.getValue();
                    if (person instanceof PetOwner) {
                        Object key = tupl.getKey();
                        int id = (Integer) key;
                        
                        PetOwner petOwner = (PetOwner) person;
                        String identifier = petOwner.getEmail();
                        
                        OwnerInfo ownerInfo = new OwnerInfo(id, identifier);
                        owners.add(ownerInfo);
                    }
                }
                for (Object tuple : App.openClinic.getOwners()) {
                    Tuple tupl = (Tuple) tuple;
                    Object business = tupl.getValue();
                    if (business instanceof Farm) {
                        Object key = tupl.getKey();
                        int id = (Integer) key;
                        
                        Farm farm = (Farm) business;
                        String identifier = farm.getName();
                        
                        OwnerInfo ownerInfo = new OwnerInfo(id, identifier);
                        owners.add(ownerInfo);
                    }
                }
                break;
                
            case "farmAnimal":
                titleLabel.setText("Add Farm Animal to Clinic");
                this.type = "farmAnimal";
                for (Object tuple : App.openClinic.getOwners()) {
                    Tuple tupl = (Tuple) tuple;
                    Object business = tupl.getValue();
                    if (business instanceof Farm) {
                        Object key = tupl.getKey();
                        int id = (Integer) key;
                        
                        Farm farm = (Farm) business;
                        String identifier = farm.getName();
                        
                        OwnerInfo ownerInfo = new OwnerInfo(id, identifier);
                        owners.add(ownerInfo);
                    }
                }
                break;
            case "zooAnimal":
                titleLabel.setText("Add Zoo Animal to Clinic");
                this.type = "zooAnimal";
                for (Object tuple : App.openClinic.getOwners()) {
                    Tuple tupl = (Tuple) tuple;
                    Object business = tupl.getValue();
                    if (business instanceof Zoo) {
                        Object key = tupl.getKey();
                        int id = (Integer) key;
                        
                        Zoo zoo = (Zoo) business;
                        String identifier = zoo.getName();
                        
                        OwnerInfo ownerInfo = new OwnerInfo(id, identifier);
                        owners.add(ownerInfo);
                    }
                }
                break;
            default:
                this.goBack();
                break;
        }
        
        selector.getItems().addAll(owners);
    }
    
    @FXML
    private void goBack() throws IOException {
        App.setRoot("MainMenu");
    }
    
    @FXML
    private void onSubmit() throws IOException, ValidationException {
        // Gets
        String name = tfPetName.getText();
        String age = tfPetAge.getText();
        String colour = tfPetColour.getText();
        String species = tfPetSpecies.getText();
        Object owner = selector.getValue();
        
        // Check if any of the required fields are empty
        if (name.isEmpty() || age.isEmpty() || colour.isEmpty() || species.isEmpty() || owner == null) {
            App.popup.showError("Error", "Please fill in all fields.");
            return; // Stops executing code block
        }
        
        try {
            OwnerInfo info = (OwnerInfo) owner;
            int id = info.getId();
            if (null == this.type) {
                // Handle unrecognized animal type
                throw new IllegalArgumentException("Invalid animal type");
            } else switch (this.type) {
                case "housePet":
                    HousePet housePet = new HousePet(name, age, colour, species, id);
                    App.openClinic.addAnimal(housePet);
                    App.popup.showMessage("Created House Pet", "Created House Pet name: " + name);
                    App.setRoot("mainMenu");
                    break;
                case "exoticAnimal":
                    ExoticAnimal exoticAnimal = new ExoticAnimal(name, age, colour, species, id);
                    App.openClinic.addAnimal(exoticAnimal);
                    App.popup.showMessage("Created Exotic Animal", "Created Exotic Animal with name: " + name);
                    App.setRoot("mainMenu");
                    break;
                case "farmAnimal":
                    FarmAnimal farmAnimal = new FarmAnimal(name, age, colour, species, id);
                    App.openClinic.addAnimal(farmAnimal);
                    App.popup.showMessage("Created Farm Animal", "Created Farm Animal with name: " + name);
                    App.setRoot("mainMenu");
                    break;
                case "zooAnimal":
                    ZooAnimal zooAnimal = new ZooAnimal(name, age, colour, species, id);
                    App.openClinic.addAnimal(zooAnimal);
                    App.popup.showMessage("Created Zoo Animal", "Created Zoo Animal with name: " + name);
                    App.setRoot("mainMenu");
                    break;
                default:
                    // Handle unrecognized animal type
                    throw new IllegalArgumentException("Invalid animal type");
            }
        } catch (ValidationException | IllegalArgumentException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
}
