package com.dstu.p7;

import javax.swing.*;

public class MyFrame extends JFrame {

    GraphicsDemo graphicsDemo = new GraphicsDemo();

    public MyFrame(){

        this.setSize(600,600);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphicsDemo);
        this.setVisible(true);



    }

}
