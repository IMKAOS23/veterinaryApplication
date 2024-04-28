package com.mycompany.veterinaryApplication;

import com.mycompany.veterinaryApplication.classes.Clinic;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.fxml.FXML;


public class MainMenuStateController {   
    @FXML
    private void submitSearch() throws IOException {
        
    }
    
    @FXML
    private void createAnimal() throws IOException {
        App.setRoot("AddPetState");
    }
    
    @FXML
    private void createVet() throws IOException {
        
    }
    
    @FXML
    private void createOwner() throws IOException {
        
    }
    
    @FXML
    private void createZoo() throws IOException {
        
    }
    
    @FXML
    private void createClinic() throws IOException {
        Clinic clinic = new Clinic("Freds Veterinary Surgery");
        System.out.println(clinic.getName());
    }
    
    @FXML
    private void openClinic() throws IOException, ClassNotFoundException{
        try (FileInputStream fileIn = new FileInputStream("Freds Veterinary Surgery.txt");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Clinic clinic = (Clinic) objectIn.readObject();
            App.openClinic = clinic;
            System.out.println("Clinic name - " + clinic.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    @FXML
    private void closeClinic() throws IOException {
        App.openClinic = null;
    }
}