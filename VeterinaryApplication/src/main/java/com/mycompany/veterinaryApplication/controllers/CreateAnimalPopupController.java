package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CreateAnimalPopupController {
    @FXML
    private Button closeButton;
    
    @FXML
    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void createHousePet() throws IOException {
        this.closeDialog();
        App.type = "housePet";
        App.setRoot("AddAnimal");
    }
    
    @FXML 
    private void createExoticAnimal() throws IOException{
        this.closeDialog();
        App.type = "exoticAnimal";
        App.setRoot("AddAnimal");
    }
    
    @FXML
    private void createFarmAnimal() throws IOException {
        this.closeDialog();
        App.type = "farmAnimal";
        App.setRoot("AddAnimal");
    }
    
    @FXML
    private void createZooAnimal() throws IOException {
        this.closeDialog();
        App.type = "zooAnimal";
        App.setRoot("AddAnimal");
        
    }
}