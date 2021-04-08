package org.example;

import javafx.scene.image.Image;

public class Bullet extends Sprite{

    private double velY;

    public Bullet(Image image, double posX, double posY) {
        super(image);
        setPosX(posX);
        setPosY(posY);
        velY = 3.00f;
    }

    @Override
    public void move(){
       setPosY(getPosY()-velY);
    }
}
