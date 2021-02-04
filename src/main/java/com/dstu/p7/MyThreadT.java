package com.dstu.p7;

import java.awt.*;
import java.util.Random;

public class MyThreadT extends Thread {

    public void run(Graphics g, int[] xTriangle, int[] yTriangle){
        Random color = new Random();
        g.setColor(new Color(color.nextInt()));
        g.fillPolygon(xTriangle,yTriangle,3);
    }

}
