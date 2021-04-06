package org.example;

import javafx.scene.image.Image;

public class CombatShip extends Sprite{

    public CombatShip(Image image) {
        super(image);
        setPosY(600-getWidth());
        setPosX(900/2);
    }

    @Override
    public void move(String direction){
        switch(direction){
            case "RIGHT":
                setPosX(getPosX()+4);
                break;
            case "LEFT":
                setPosX(getPosX()-4);
                break;
        }
    }

}
