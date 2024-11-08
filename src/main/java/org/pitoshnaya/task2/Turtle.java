package org.pitoshnaya.task2;



public class Turtle {
    int x = 0;
    int y = 0;


    public Coordinates getCoordinates(){
        Coordinates buba = new Coordinates();
        buba.setX(this.x);
        buba.setY(this.y);

        return buba;
    }
    public Turtle() {

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
