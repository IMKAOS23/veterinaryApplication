package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CreatePersonPopupController {
    @FXML
    private Button closeButton;
    
    @FXML
    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void createPetOwner() throws IOException {
        this.closeDialog();
        App.type = "petOwner";
        App.popup.showWindow("Add Pet Owner", "AddPerson");
    }
    
    @FXML 
    private void createVet() throws IOException{
        this.closeDialog();
        App.type = "vet";
        App.popup.showWindow("Add Vet", "AddPerson");
    }
}