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
    private EnemyShip enemyShip, enemyShip1, enemyShip2, enemyShip3, enemyShip4;
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
                    if(bullets.get(i).getBoundry().intersects(enemyShip.getBoundry())){
                        System.out.println("hit");
                    } else if(bullets.get(i).getBoundry().intersects(enemyShip1.getBoundry())){
                        System.out.println("hit");
                    } else if(bullets.get(i).getBoundry().intersects(enemyShip2.getBoundry())){
                        System.out.println("hit");
                    } else if(bullets.get(i).getBoundry().intersects(enemyShip3.getBoundry())){
                        System.out.println("hit");
                    } else if(bullets.get(i).getBoundry().intersects(enemyShip4.getBoundry())){
                        System.out.println("hit");
                    }
                    if(bullets.get(i).getPosY()<=0){
                        bullets.remove(i);
                        System.out.println("removed");
                    }

                }
            }

            //NPCs
            enemyShip.move();
            enemyShip.render(gc);

            enemyShip1.move();
            enemyShip1.render(gc);

            enemyShip2.move();
            enemyShip2.render(gc);

            enemyShip3.move();
            enemyShip3.render(gc);

            enemyShip4.move();
            enemyShip4.render(gc);
        }
    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        space = new Image("PNG/space.jpg");
        combatShip = new CombatShip(new Image("PNG/combat_ship.png"));
        enemyShip = new EnemyShip(new Image("PNG/enemy_ship.png"), 0,0);
        enemyShip1 = new EnemyShip(new Image("PNG/enemy_ship.png"), enemyShip.getPosX()+enemyShip.getWidth()+2, 0);
        enemyShip2 = new EnemyShip(new Image("PNG/enemy_ship.png"), enemyShip1.getPosX()+enemyShip1.getWidth()+2, 0);
        enemyShip3 = new EnemyShip(new Image("PNG/enemy_ship.png"), enemyShip2.getPosX()+enemyShip2.getWidth()+2, 0);
        enemyShip4 = new EnemyShip(new Image("PNG/enemy_ship.png"), enemyShip3.getPosX()+enemyShip3.getWidth()+2, 0);
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
