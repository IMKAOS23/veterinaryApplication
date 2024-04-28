package com.mycompany.veterinaryApplication;

import java.io.IOException;
import javafx.fxml.FXML;

public class AddPetStateController {

    @FXML
    private void switchToMainMenu() throws IOException {
        App.setRoot("MainMenuState");
    }
}