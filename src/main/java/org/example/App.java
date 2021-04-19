package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    static Stage stagemenu;
    static Stage principal;
    static PrimaryController pc;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getClassLoader().getResource("org/example/primary.fxml"));
        Parent root = loader.load();
        Scene sc = new Scene(root);
        pc = loader.getController();
        pc.setScene(sc);
        stage.setScene(sc);
        stage.setResizable(false);
        principal = stage;
        stage.show();
    }

    static void showMenu(String fxml) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(loadFXML(fxml)));
        stagemenu = stage;
        stage.setResizable(false);
        stage.show();

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    public static void main(String[] args) {
        launch();
    }

}