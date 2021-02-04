package com.dstu.p7.try2;

public class Circle {

    int x;
    int y;
    int width;
    int height;
    int dots = 1;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;


    public Circle(){};
    public Circle(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    };

    public void move(){
        checkCollisionsC();

        if (left){
            x -= dots;
        }
        if (right){
            x += dots;
        }
        if (up){
            x -= dots;
        }
        if (down){
            x -= dots;
        }
    }

    public void checkCollisionsC() {
        if (x < -1 ){
            right = true;
            left = false;
        }
        if (x > 450 ){
            right = false;
            left = true;
        }
    }

    public void circleChangeLineX() {
        if (right){
            right = false;
            left = true;
        }
        if(left){
            left = false;
            right = true;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
