package com.dstu.p7.try2;

import java.awt.*;
import java.util.Random;

public class MyThread extends Thread {
    public void run(Circle t){
        t.move();
    }
    public void run(Triangle t){
        t.move();
    }

}
