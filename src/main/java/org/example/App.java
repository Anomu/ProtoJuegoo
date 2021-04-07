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

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getClassLoader().getResource("org/example/primary.fxml"));
        Parent root = loader.load();
        Scene sc = new Scene(root);
        PrimaryController pc = loader.getController();
        pc.setScene(sc);
        stage.setScene(sc);

        //stage.setHeight(600); //revisar
        //stage.setWidth(900); //revisar

        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

}