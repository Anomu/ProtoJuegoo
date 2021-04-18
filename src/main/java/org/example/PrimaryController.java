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
    private ArrayList<Bullet> bullets = new ArrayList<>();
    private ArrayList<EnemyBullet> enemybullets = new ArrayList<>();
    private Image space;
    private boolean jugando = true;

    @FXML
    Canvas mainCanvas;

        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(0.007), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

                    gc.drawImage(space, 0, 0, 900, 600);

            //player
            combatShip.render(gc);

            //Bullet
            //for recorriendo list haciendo lo de abajo
            if(bullets.size()>0) {
                for (int i = 0; i < bullets.size(); i++) {
                    bullets.get(i).move();
                    bullets.get(i).render(gc);

                    if(bullets.get(i).getPosY()<=0){
                        bullets.remove(i);
                        System.out.println("removed");
                        break;
                    }

                    for (int j = 0; j < enemyShips.size(); j++) {
                        if (bullets.get(i).getBoundry().intersects(enemyShips.get(j).getBoundry())) {
                            System.out.println("de locos");
                            System.out.println("nave " + j);
                            enemyShips.remove(j);
                            bullets.remove(i);
                            break;

                        }
                    }
                }
            }

            for (int i = 0; i < enemyShips.size(); i++) {
                double random = Math.random();
                //System.out.println(random);
                if(random>0.9993 && enemybullets.size() <= 2) {
                    enemybullets.add(new EnemyBullet(new Image("PNG/bullet.png"),
                            enemyShips.get(i).getPosX() + (enemyShips.get(i).getWidth() / 2.65),
                            enemyShips.get(i).getPosY()));
                    System.out.println("dispara el ship" + i);
                }
            }
            if (enemybullets.size() > 0) {
                for (int i = 0; i < enemybullets.size(); i++) {
                    enemybullets.get(i).move();
                    enemybullets.get(i).render(gc);

                            if (enemybullets.get(i).getPosY() >= 500) {
                                enemybullets.remove(i);
                                System.out.println("removed");
                                break;
                            }

                            if (enemybullets.get(i).getBoundry().intersects(combatShip.getBoundry())) {
                                jugando = false;
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
        combatShip = new CombatShip(new Image("PNG/combat_ship_v2.png"));
        int spacing = 0;
        for (int i = 0; i < 5; i++) {
            enemyShips.add(new EnemyShip(new Image("PNG/enemy_ship_v2.png"), 0+spacing, 0));
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
                if(bullets.size()==0) {
                    bullets.add(new Bullet(new Image("PNG/bullet.png"),
                            combatShip.getPosX() + (combatShip.getWidth() / 2.65),
                            combatShip.getPosY()));
                }
            }
            System.out.println(keyEvent.getCode().toString());
        });
    }
}
