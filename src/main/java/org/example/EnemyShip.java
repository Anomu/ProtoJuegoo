package org.example;

import javafx.scene.image.Image;

public class EnemyShip extends Sprite{
    private double velX, velY;
    private int dirX, dirY;

    public EnemyShip(Image image) {
        super(image);
        setPosY(0+getHeight());
        setPosX(0);
        velX = 1.0f;
        velY = 5.0f;
        dirX = 1;
        dirY = 1;
    }

    @Override
    public void move() {
        if(dirX == 1) {
            setPosX(getPosX() + velX);
            if(getPosX()>=600-getWidth()) {
                dirX = (-1)*dirX;
                setPosY(getPosY() + velY);
            }
        }else {
            setPosX(getPosX() - velX);
            if(getPosX() <= 0) dirX = (-1)*dirX;
        }
    }
}
