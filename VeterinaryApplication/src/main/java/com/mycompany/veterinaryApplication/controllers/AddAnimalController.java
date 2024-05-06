package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddAnimalController {
    private String type;
    
    @FXML
    private Label titleLabel;
    
    @FXML
    private Button btnClose;
    
    
    public void initialize() {
        if (null == App.type) {
            this.closeDialog();
        } else switch (App.type) {
            case "housePet":
                titleLabel.setText("Add House Pet to Clinic");
                this.type = "housePet";
                break;
            case "exoticAnimal":
                titleLabel.setText("Add Exotic Animal to Clinic");
                this.type = "exoticAnimal";
                break;
            case "farmAnimal":
                titleLabel.setText("Add Farm Animal to Clinic");
                this.type = "farmAnimal";
                break;
            case "zooAnimal":
                titleLabel.setText("Add Zoo Animal to Clinic");
                this.type = "zooAnimal";
                break;
            default:
                this.closeDialog();
                break;
        }
    }
    
    @FXML
    private void closeDialog() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void onSubmit() throws IOException {
        
    }
}