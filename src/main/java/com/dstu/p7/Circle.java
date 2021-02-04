package com.dstu.p7;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle  {

    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 550;

    private int x;
    private int y;
    private int width;
    private int height;

    private int dots;
    private Timer timer;

    private boolean left = true;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;





    private void moveCircle(){
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

    private void checkCollisionsC() {
        if (x < 40 ){
            right = true;
            left = false;
        }
        if (x > ALL_DOTS - 20 ){
            right = false;
            left = true;
        }
    }

    private void circleChangeLineX() {
        if (right){
            right = false;
            left = true;
        }
        if(left){
            left = false;
            right = true;
        }
    }

}
