package org.example;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.util.Duration;

public class PrimaryController implements Initializable {
    private Scene scene;
    private GraphicsContext gc;
    private CombatShip combatShip;
    private ArrayList<EnemyShip> enemyShips = new ArrayList<>();
    //list de bullets
    private ArrayList<Bullet> bullets = new ArrayList<>();
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
            if(bullets.size()>0) {
                for (int i = 0; i < bullets.size(); i++) {
                    bullets.get(i).move();
                    bullets.get(i).render(gc);
                    if(bullets.get(i).getBoundry().intersects(enemyShips.get(0).getBoundry())){
                        //enemyShips.remove(0);
                        System.out.println("hit");
                    } else if(bullets.get(i).getBoundry().intersects(enemyShips.get(1).getBoundry())){
                        //enemyShips.remove(1);
                        System.out.println("hit");
                    } else if(bullets.get(i).getBoundry().intersects(enemyShips.get(2).getBoundry())){
                        System.out.println("hit");
                        //enemyShips.remove(2);
                    } else if(bullets.get(i).getBoundry().intersects(enemyShips.get(3).getBoundry())){
                        System.out.println("hit");
                        //enemyShips.remove(3);
                    } else if(bullets.get(i).getBoundry().intersects(enemyShips.get(4).getBoundry())){
                        System.out.println("hit");
                        //enemyShips.remove(4);
                    }
                    if(bullets.get(i).getPosY()<=0){
                        bullets.remove(i);
                        System.out.println("removed");
                    }

                }
            }

            //NPCs
            for (int i = 0; i < enemyShips.size(); i++) {
                enemyShips.get(i).move();
                enemyShips.get(i).render(gc);
            }
        }
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        space = new Image("PNG/space.jpg");
        combatShip = new CombatShip(new Image("PNG/combat_ship.png"));
        int spacing = 0;
        for (int i = 0; i < 5; i++) {
            enemyShips.add(new EnemyShip(new Image("PNG/enemy_ship.png"), 0+spacing, 0));
            spacing = spacing+150;
        }
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
                bullets.add(new Bullet(new Image("PNG/bullet.png"),
                        combatShip.getPosX()+ (combatShip.getWidth()/2),
                        combatShip.getPosY()));
            }
            System.out.println(keyEvent.getCode().toString());
        });
    }
}
