package com.mycompany.veterinaryApplication.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddPersonController {
    
    @FXML
    private Button btnClose;

    public void initialize() {
        
    }
    
    @FXML
    private void closeDialog() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}