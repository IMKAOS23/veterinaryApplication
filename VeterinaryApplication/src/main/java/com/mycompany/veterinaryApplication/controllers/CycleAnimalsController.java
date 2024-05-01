package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class CycleAnimalsController {

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenuState");
    }
}