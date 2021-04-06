package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class PrimaryController implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private CombatShip combatShip;

    @FXML
    Canvas mainCanvas;

    /*
    Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0.0017), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

        }
    }));

     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        combatShip = new CombatShip(new Image("PNG/combat_ship.png"));
        gc = mainCanvas.getGraphicsContext2D();
        combatShip.render(gc);
    }


    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnKeyPressed(keyEvent -> {
            combatShip.clear(gc);
            combatShip.move(keyEvent.getCode().toString());
            combatShip.render(gc);
        });
    }
}
