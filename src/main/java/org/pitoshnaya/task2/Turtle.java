package org.pitoshnaya.task2;


import java.util.Random;

public class Turtle {
    int x = 0;
    int y = 0;

    public Turtle() {
        Random random = new Random();
        int randX = random.nextInt(10);
        int randY = random.nextInt(10);
        this.x = randX;
        this.y = randY;
    }

    public Coordinates getCoordinates(){

        Coordinates buba = new Coordinates();
        buba.setX(this.x);
        buba.setY(this.y);

        return buba;
    }


    public void moveUp(){

        y = y - 1;
    }

    public void moveDown(){
        y = y + 1;
    }
    public void moveLeft(){
        x = x - 1;
    }
    public void moveRight(){
        x = x + 1;
    }



}
