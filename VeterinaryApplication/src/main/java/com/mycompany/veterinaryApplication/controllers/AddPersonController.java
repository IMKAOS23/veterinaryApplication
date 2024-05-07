package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.person.PetOwner;
import com.mycompany.veterinaryApplication.components.person.Vet;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AddPersonController {
    String type;
    
    @FXML
    private Label titleLabel;
    
    @FXML 
    private Pane parentPane;
    
    @FXML
    private Label specialityLabel;
    
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPhone;
    @FXML
    private TextField tfHouseNumber;
    @FXML
    private TextField tfStreetName;
    @FXML
    private TextField tfPostcode;
    @FXML 
    private TextField tfCity;
    @FXML
    private TextField tfSpeciality;
    
    

    public void initialize() throws IOException {
        if (null == App.type) {
            this.goBack();
        } else switch (App.type) {
            case "petOwner":
                parentPane.getChildren().remove(specialityLabel);
                parentPane.getChildren().remove(tfSpeciality);
                titleLabel.setText("Add Pet Owner to Clinic");
                this.type = App.type;
                break;
            case "vet":
                this.type = App.type;
                break;
        }
    }
    
    @FXML
    private void goBack() throws IOException {
        App.setRoot("MainMenu");
    }
    
    @FXML
    private void onSubmit() throws ValidationException, IOException {
        String fName = tfFirstName.getText();
        String lName = tfLastName.getText();
        String age = tfAge.getText();
        String email = tfEmail.getText();
        String phoneNumber = tfPhone.getText();
        String houseNumber = tfHouseNumber.getText();
        String streetName = tfStreetName.getText();
        String postcode = tfPostcode.getText();
        String city = tfCity.getText();
        
        if (fName.isEmpty() || lName.isEmpty() || age.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()
                || houseNumber.isEmpty() || streetName.isEmpty() || postcode.isEmpty() || city.isEmpty()) {
            App.popup.showError("Error", "Please fill in all fields");
            return;
        }
        try {
            if ("petOwner".equals(App.type)) {
                PetOwner petOwner = new PetOwner(fName, lName, age, email, phoneNumber, houseNumber, streetName, postcode, city);
                App.openClinic.addOwner(petOwner);
                App.popup.showMessage("Created Pet Owner", "Created Pet Owner with email: " + email);
                App.setRoot("mainMenu");
            } else {
                String speciality = tfSpeciality.getText();
                if (speciality.isEmpty()) {
                    App.popup.showError("Error", "Please fill in all fields");
                    return;
                }
                Vet vet = new Vet(fName, lName, age, email, phoneNumber, houseNumber, streetName, postcode, city, speciality);
                App.openClinic.addOwner(vet);
                App.popup.showMessage("Created Vet", "Created Vet with email: " + email);
                App.setRoot("mainMenu");
            }
        } catch (ValidationException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
}