package org.example;

import javafx.scene.image.Image;

public class EnemyShip extends Sprite{
    private double velX, velY;
    private int dirX, dirY;

    public EnemyShip(Image image) {
        super(image);
        velX = 1.0f;
        velY = 5.0f;
        dirX = 1;
        dirY = 1;
    }

    public void move (){

    }
}
