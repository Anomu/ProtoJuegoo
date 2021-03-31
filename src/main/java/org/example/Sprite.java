package org.example;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Sprite{
    private Image image;
    private double width, height, posX, posY;

    public void move(){
        return;
    }

    public void move(String dir){
        return;
    }

    public Sprite (Image image){
        setImage(image);
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private void setImage(Image image){
        this.image=image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public void render(GraphicsContext gc){
        gc.drawImage(image, posX, posY);
    }

    public void clear(GraphicsContext gc){
        gc.clearRect(posX, posX, width, height);
    }

    public Rectangle2D getBoundry(){
        return new Rectangle2D(posX, posY, width, height);
    }

}
