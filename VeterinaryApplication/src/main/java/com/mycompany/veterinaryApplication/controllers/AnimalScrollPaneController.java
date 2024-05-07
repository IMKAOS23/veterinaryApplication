/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.veterinaryApplication.controllers;

import com.mycompany.veterinaryApplication.App;
import com.mycompany.veterinaryApplication.components.Tuple;
import com.mycompany.veterinaryApplication.components.animal.Animal;
import java.io.IOException;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author markc
 */
public class AnimalScrollPaneController {
    private ScrollPane scrollPane;
    
    public AnimalScrollPaneController(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    
    public void populateScrollPane(List<Tuple> animals) throws IOException{
        VBox container = new VBox();
        
        // Preset text to be used if no animals in Clinic
        if (animals.isEmpty()) {
            Label noAnimals = new Label("There are no Animals in this Clinic");
            container.getChildren().add(noAnimals);
            this.scrollPane.setContent(container);
            return;
        }
        
        // If item in Clinic this is used
        for (Tuple tuple : animals) {
            Animal animal = (Animal) tuple.getValue();
            int id = (int) tuple.getKey();
            HBox animalBox = generateAnimalBox(animal, id);
            
            container.getChildren().add(animalBox);
        }
        this.scrollPane.setContent(container);
    }
    
    public HBox generateAnimalBox(Animal animal, int id) {
        Label nameLabel = new Label("Name: " + animal.getName());
        Label ageLabel = new Label("Age: " + animal.getAge());
        Label colourLabel = new Label("Colour: " + animal.getColour());
        Label speciesLabel = new Label("Species: " + animal.getSpecies());
        Label ownerLabel = new Label("Owner: " + id);
        Label objectLabel = new Label("Type of Animal: " + animal.getClass().getSimpleName());
        
        Button viewButton = new Button("View Animal");
        viewButton.setUserData(id);
        viewButton.setOnAction(event -> {
            int animalIndex = (int) viewButton.getUserData();
            App.currentId = animalIndex;
            try {
                App.setRoot("CycleAnimals");
            } catch (IOException ex) {
                App.popup.showError("Error", "Something bad happened");
            }
        });
        
        HBox animalBox = new HBox(nameLabel, ageLabel, colourLabel, speciesLabel, ownerLabel, objectLabel, viewButton);
        animalBox.setSpacing(10);
        animalBox.setPadding(new Insets(5, 5, 5, 5));
        
        return animalBox;
    }
}
