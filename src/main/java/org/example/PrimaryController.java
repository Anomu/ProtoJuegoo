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
    private EnemyShip enemyShip, enemyShip1, enemyShip2;
    //list de bullets
    private Bullet bullet;
    private Image space;

    @FXML
    Canvas mainCanvas;


    Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0.005), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {

            gc.drawImage(space,0, 0, 900, 600);

            //player
            combatShip.render(gc);

            //Bullet
            //for recorriendo list haciendo lo de abajo
            bullet.setPosY(combatShip.getPosX());
            bullet.setPosX(combatShip.getPosY());
            bullet.move();
            bullet.render(gc);

            //NPCs
            enemyShip.move();
            enemyShip.render(gc);

            enemyShip1.setPosX(enemyShip.getPosX()+enemyShip.getWidth()+2);
            enemyShip1.setPosY(enemyShip.getPosY());
            enemyShip1.move();
            enemyShip1.render(gc);

            enemyShip2.setPosX(enemyShip1.getPosX()+enemyShip1.getWidth()+2);
            enemyShip2.setPosY(enemyShip.getPosY());
            enemyShip2.move();
            enemyShip2.render(gc);



        }
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        space = new Image("PNG/2513478.jpg");
        combatShip = new CombatShip(new Image("PNG/combat_ship.png"));
        bullet = new Bullet(new Image("PNG/bullet.png"));
        enemyShip = new EnemyShip(new Image("PNG/enemy_ship.png"));
        enemyShip1 = new EnemyShip(new Image("PNG/enemy_ship.png"));
        enemyShip2 = new EnemyShip(new Image("PNG/enemy_ship.png"));
        gc = mainCanvas.getGraphicsContext2D();
        combatShip.render(gc);

        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }

    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnKeyPressed(keyEvent -> {
            combatShip.move(keyEvent.getCode().toString());
            if(keyEvent.getCode().toString().equals("SPACE")){
                //crear nueva bullet y añadir al list
            }
            System.out.println(keyEvent.getCode().toString());
        });
    }
}
