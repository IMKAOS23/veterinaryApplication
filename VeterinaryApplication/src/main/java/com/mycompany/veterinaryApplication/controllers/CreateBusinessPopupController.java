package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CreateBusinessPopupController {
    @FXML
    private Button closeButton;
    
    @FXML
    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void createFarm() throws IOException {
        this.closeDialog();
        App.type = "farm";
        App.setRoot("AddBusiness");
    }
    
    @FXML 
    private void createZoo() throws IOException{
        this.closeDialog();
        App.type = "zoo";
        App.setRoot("AddBusiness");
    }
}