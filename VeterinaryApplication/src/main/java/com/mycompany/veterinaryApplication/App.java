package com.mycompany.veterinaryApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import com.mycompany.veterinaryApplication.components.Clinic;
import com.mycompany.veterinaryApplication.components.Validator;
import java.util.List;

/**
 * JavaFX App
 * @author Markc
 */
public class App extends Application {

    public static Scene scene;
    public static Clinic openClinic;
    public List animalList;
    public static Validator validator = new Validator();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainMenu"));
        stage.setTitle("Vet Application");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}