package com.dstu.p7;

import java.awt.*;
import java.util.Random;

public class MyThreadC extends Thread {

    public void run(Graphics g, int xCircle, int yCircle){
        Random color = new Random();
        g.setColor(new Color(color.nextInt()));
        g.fillOval(xCircle, yCircle, 30,30);
    }
}
