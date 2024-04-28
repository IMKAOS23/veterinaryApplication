package com.mycompany.veterinaryApplication;

import com.mycompany.veterinaryApplication.classes.Clinic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * @author Markc
 */
public class App extends Application {

    private static Scene scene;
    public static Clinic openClinic;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainMenuState"));
        stage.setTitle("Vet Application");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
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