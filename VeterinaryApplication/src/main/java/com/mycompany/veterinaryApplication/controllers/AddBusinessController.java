package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.business.Farm;
import com.mycompany.veterinaryApplication.components.business.Zoo;
import com.mycompany.veterinaryApplication.exceptions.ValidationException;
import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddBusinessController {
    String type;
    
    @FXML
    private Label titleLabel;
    
    @FXML
    private TextField tfBusinessName;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField tfStreetName;
    @FXML
    private TextField tfPostcode;
    @FXML
    private TextField tfCity;
    
    public void initialize() throws IOException {
        if (null == App.type) {
            this.goBack();
        } else switch (App.type) {
            case "farm":
                titleLabel.setText("Add Farm to Clinic");
                this.type = "farm";
                break;
            case "zoo":
                titleLabel.setText("Add Zoo to Clinic");
                this.type = "zoo";
                break;
        }
    }
    
    @FXML
    public void goBack() throws IOException {
        App.setRoot("MainMenu");
    }
    
    @FXML
    private void onSubmit() throws ValidationException, IOException {
        String name = tfBusinessName.getText();
        LocalDate openDate = datePicker.getValue();
        String streetName = tfStreetName.getText();
        String postcode = tfPostcode.getText();
        String city = tfCity.getText();
        
        if (streetName.isEmpty() || name.isEmpty() || postcode.isEmpty() || city.isEmpty() || openDate.toString().isEmpty()) {
            App.popup.showError("Error", "Please fill in all fields");
            return;
        }
        
        try {
            if (null == this.type) {
                    // Handle unrecognized animal type
                    throw new IllegalArgumentException("Invalid animal type");
                } else switch (this.type) {
                    case "farm":
                        Farm farm = new Farm(name, openDate, streetName, postcode, city);
                        App.openClinic.addOwner(farm);
                        App.popup.showMessage("Created Farm", "Created Farm with name: " + name);
                        App.setRoot("mainMenu");
                        break;
                    case "zoo":
                        Zoo zoo = new Zoo(name, openDate, streetName, postcode, city);
                        App.openClinic.addOwner(zoo);
                        App.popup.showMessage("Created Zoo", "Created Zoo with name: " + name);
                        App.setRoot("mainMenu");
                        break;
                    default:
                    // Handle unrecognized animal type
                    throw new IllegalArgumentException("Invalid animal type");
                }
        } catch (ValidationException e) {
            App.popup.showError("Error", e.getMessage());
        }
    }
}