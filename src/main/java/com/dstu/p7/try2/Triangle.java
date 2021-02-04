package com.dstu.p7.try2;


public class Triangle {

    private int[] x;
    private int[] y;
    private final int nPoints = 3;

    int dots = 1;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;


    public Triangle(){};
    public Triangle(int[] x, int[] y){
        this.x=x;
        this.y=y;
    }

    public void move(){
        checkCollisionsT();
        if (left){
            changeValues(x, -dots);
        }
        if (right){
            changeValues(x, dots);
        }
        if (up){
            changeValues(y,dots);
        }
        if (down){
            changeValues(y,-dots);
        }
    }
    private void checkCollisionsT() {
        if (x[0] < 40 ){
            right = true;
            left = false;
        }
        if (x[2] > 550 ){
            right = false;
            left = true;
        }
    }

    public void changeValues(int[] t, int a){

        for (int i = 0; i < t.length; i++) {
            t[i] += a;
        }
    }

    public int getnPoints() {
        return nPoints;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int getDots() {
        return dots;
    }

    public void setDots(int dots) {
        this.dots = dots;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
