package org.example;

import javafx.scene.image.Image;

public class EnemyBullet extends Sprite{

    private double velY;

    public EnemyBullet(Image image, double posX, double posY) {
        super(image);
        setPosX(posX);
        setPosY(posY);
        velY = 3.00f;
    }

    @Override
    public void move(){
       setPosY(getPosY()+velY);
    }
    
}
