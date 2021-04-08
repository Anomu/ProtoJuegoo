package org.example;

import javafx.scene.image.Image;

public class EnemyShip extends Sprite{
    private double velX, velY;
    private int dirX, dirY;

    public EnemyShip(Image image, double posX, double posY) {
        super(image);
        setPosY(posY);
        setPosX(posX);
        velX = 1.0f;
        velY = 5.0f;
        dirX = 1;
        dirY = 1;
    }

    @Override
    public void move() {
        if(dirX == 1) {
            setPosX(getPosX() + velX);
            if(getPosX()>=900-getWidth()) {
                dirX = (-1)*dirX;
                setPosY(getPosY() + velY);
            }
        }else {
            setPosX(getPosX() - velX);
            if(getPosX() <= 0) dirX = (-1)*dirX;
        }
    }
}
