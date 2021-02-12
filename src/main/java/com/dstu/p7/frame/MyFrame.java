package com.dstu.p7.frame;

import com.dstu.p7.panel.MyPanel;

import javax.swing.*;

public class MyFrame
        extends JFrame
        implements com.dstu.p7.interfaces.MyFrame
         {

    MyPanel panel;
    public MyFrame(){
        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
