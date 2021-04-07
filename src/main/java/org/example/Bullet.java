package org.example;

import javafx.scene.image.Image;

public class Bullet extends Sprite{

    private double velY;

    public Bullet(Image image) {
        super(image);
        velY = 7.00f;
    }

    @Override
    public void move(){
       setPosY(getPosY()-velY);
    }
}
