package com.dstu.p7.thread;

import com.dstu.p7.triangle.Triangle;
import com.dstu.p7.circle.Circle;

public class MyThread
        extends Thread
        implements com.dstu.p7.interfaces.MyThread
{
    public void run(Circle t){
        moveC(t);
    }
    public void run(Triangle t){
        moveT(t);
    }

    public void moveC(Circle circle){
        checkCollisionsC(circle);

        if (circle.isLeft()){
            circle.setX(circle.getX() - circle.getDots());
        }
        if (circle.isRight()){
            circle.setX(circle.getX() + circle.getDots());
        }
        if (circle.isUp()){
            circle.setY(circle.getY() - circle.getDots());
        }
        if (circle.isDown()){
            circle.setY(circle.getY() + circle.getDots());
        }
    }

    public void checkCollisionsC(Circle circle) {
        if (circle.getX() < -1 ){
            circle.setRight(true);
            circle.setLeft(false);
        }
        if (circle.getX() > 450 ){
            circle.setRight(false);
            circle.setLeft(true);
        }
    }

    public void circleChangeLineX(Circle circle) {
        if (circle.isRight()){
            circle.setRight(false);
            circle.setLeft(true);
        }
        if(circle.isLeft()){
            circle.setLeft(false);
            circle.setRight(true);
        }
    }

    public void moveT(Triangle triangle){
        checkCollisionsT(triangle);
        if (triangle.isLeft()){
            changeValues(triangle.getX(), -triangle.getDots());
        }
        if (triangle.isRight()){
            changeValues(triangle.getX(), triangle.getDots());
        }
        if (triangle.isUp()){
            changeValues(triangle.getY(), - triangle.getDots());
        }
        if (triangle.isDown()){
            changeValues(triangle.getY(), triangle.getDots());
        }
    }
    private void checkCollisionsT(Triangle triangle) {
        if (triangle.getX()[0] < 40 ){
            triangle.setRight(true);
            triangle.setLeft(false);
        }
        if (triangle.getX()[2] > 500 ){
            triangle.setRight(false);
            triangle.setLeft(true);
        }
    }

    public void changeValues(int[] t, int a){

        for (int i = 0; i < t.length; i++) {
            t[i] += a;
        }
    }

}
