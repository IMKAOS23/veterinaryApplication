/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.components;

import com.mycompany.veterinaryApplication.App;
import java.io.IOException;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Class with No constructor. Used to Create popups for the user to show success or failure in different components. 
 * For User Experience.
 * 
 * @author markc
 */
public class Popup {
    /**
     * Methods takes in 2 parameters Title and Message and creates an instance of the alert class to display the Error
     * 
     * @param title
     * @param message 
     */
    public void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Methods takes in 2 parameters, title and message, and displays a confirmation box for with that message.
     * 
     * @param title
     * @param message
     * 
     * @return true if OK button was pressed
     */
    public boolean showConfirm(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
        
        return result == ButtonType.OK;
    }
    
    /**
     * Method takes in 2 parameters, title and message, and displays a popup of type INFORMATION with that message
     * 
     * @param title
     * @param message 
     */
    public void showMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    /**
     * Method that creates a popup with a custom style
     * Takes in 2 parameters, title and the FXML used to within the Window
     * Uses same FXML as App's private LoadFXML Method
     * 
     * @param title
     * @param fxml
     * 
     * @throws IOException 
     */
    public void showWindow(String title, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        popupStage.setScene(new Scene(root));
        popupStage.setResizable(false);
        
        popupStage.showAndWait();
    }
    
    /**
     * Creates a Text Input Dialog with the 3 given parameters, title, headerText and ContentText
     * 
     * @param title
     * @param headerText
     * @param contentText
     * 
     * @return null | userInput 
     * 
     * @throws IOException 
     */
    public String showTextInput(String title, String headerText, String contentText) throws IOException{
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);
        dialog.setContentText(contentText);
        dialog.setResizable(false);
        
        Optional<String> result = dialog.showAndWait();
        
        if (result.isPresent()) {
            String userInput = result.get();
            return userInput;
        }
        // Null is returned if the user cancels out of the textInput box and does not show error.
        return null;
    }
}
