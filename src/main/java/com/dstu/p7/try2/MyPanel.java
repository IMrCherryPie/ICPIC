package com.dstu.p7.try2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    Timer timer;
    private ArrayList<Circle> circles = new ArrayList<>();
    private ArrayList<Triangle> triangles = new ArrayList<>();

    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        this.addKeyListener(new FieldKeyListener());
        setFocusable(true);

        x = 50;
        y = 50;

        circles.add(new Circle(10,10,30,30));
        circles.add(new Circle(10,50,30,30));

        triangles.add(new Triangle(new int[]{10, 20, 30}, new int[]{30, 13, 30}));
        triangles.add(new Triangle(new int[]{10, 20, 30}, new int[]{90, 39, 90}));



        timer = new Timer(10,this);
        timer.start();


    }

    public void paint(Graphics g){

        super.paint(g);
        Random color = new Random();
        Graphics2D g2D = (Graphics2D) g;

        g.setColor(new Color(150, 250, 150));
        g.fillArc(x, y, 30, 30, 180, 270);

        for (int i = 0; i < circles.size(); i++) {
            Circle circle;
            circle = circles.get(i);
            g2D.setColor(new Color(color.nextInt()));
            g2D.fillOval(circle.getX(),circle.getY(),circle.getWidth(),circle.getHeight());
        }
        for (int i = 0; i < triangles.size(); i++) {
            Triangle triangle = triangles.get(i);
            g2D.setColor(new Color(color.nextInt()));
            g2D.fillPolygon(triangle.getX(),triangle.getY(),triangle.getnPoints());
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < circles.size(); i++) {
            Circle circle = circles.get(i);
            if (x == circle.getX() && y == circle.getY()){
                new MyThread().circleChangeLineX(circle);
            }
            new MyThread().run(circle);
        }
        if(!triangles.isEmpty()) {
            for (int i = 0; i < triangles.size(); i++) {
                Triangle triangle = triangles.get(i);
                new MyThread().run(triangle);
            }
        }


        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && x > -1){
                x -= xVelocity;
            }
            if (key == KeyEvent.VK_RIGHT && x < PANEL_WIDTH){
                x += xVelocity;
            }
            if (key == KeyEvent.VK_UP && y > -1){
                y -= yVelocity;
            }
            if (key == KeyEvent.VK_DOWN && y < PANEL_HEIGHT - 20 ){
                y += yVelocity;
            }
        }
    }
}
