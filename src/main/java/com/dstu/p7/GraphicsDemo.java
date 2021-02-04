package com.dstu.p7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class GraphicsDemo
        extends JPanel
        implements ActionListener {

    private final int SIZE = 600;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 550;

    private int[] xTriangle;
    private int[] yTriangle;

    private int xCircle;
    private int yCircle;

    private int xPixel;
    private int yPixel;

    private int dots;
    private Timer timer;

    private boolean leftC = true;
    private boolean rightC = false;
    private boolean upC = false;
    private boolean downC = false;

    private boolean leftT = false;
    private boolean rightT = true;
    private boolean upT = false;
    private boolean downT = false;





    public GraphicsDemo(){
        initGame();
        addKeyListener(new GraphicsDemo.FieldKeyListener());
        setFocusable(true);
    }

    public void initGame(){
        dots = 20;
        xCircle = 550;
        yCircle = 50;

        xTriangle = new int[]{10, 20, 30};
        yTriangle = new int[]{30, 13, 30};

        xPixel = 50;
        yPixel = 50;

        timer= new Timer(250,this);
        timer.start();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Random color = new Random();

        this.setBackground(Color.black);


        g.setColor(new Color(color.nextInt()));
        g.fillOval(xCircle, yCircle, 30,30);
        g.setColor(new Color(color.nextInt()));
        g.fillOval(xCircle + 2*dots, yCircle, 30,30);
        g.setColor(new Color(color.nextInt()));
        g.fillOval(xCircle+4*dots, yCircle, 30,30);

        MyThreadT myThreadT = new MyThreadT();
        myThreadT.run(g, xTriangle, yTriangle);

        g.setColor(new Color(150, 250, 150));
        g.fillArc(xPixel, yPixel, 30, 30, 180, 270);

    }

    private void moveCircle(){
        if (leftC){
            xCircle -= dots;
        }
        if (rightC){
            xCircle += dots;
        }
        if (upC){
            xCircle -= dots;
        }
        if (downC){
            xCircle -= dots;
        }
    }

    private void moveTriangle(){
        Service s = new Service();
        if (leftT){
            s.changeValues(xTriangle, -dots);
        }
        if (rightT){
            s.changeValues(xTriangle, dots);
        }
        if (upT){
            s.changeValues(yTriangle,dots);
        }
        if (downT){
            s.changeValues(yTriangle,-dots);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisionsC();
        checkCollisionsT();
        if (xPixel == xCircle && yPixel == yCircle){
            circleChangeLineX();
        }
        moveCircle();
        moveTriangle();
        repaint();
    }



    private void checkCollisionsT() {
        if (xTriangle[0] < 40 ){
            rightT = true;
            leftT = false;
        }
        if (xTriangle[2] > ALL_DOTS ){
            rightT = false;
            leftT = true;
        }
    }

    private void checkCollisionsC() {
        if (xCircle < 40 ){
            rightC = true;
            leftC = false;
        }
        if (xCircle > ALL_DOTS - 20 ){
            rightC = false;
            leftC = true;
        }
    }


    class FieldKeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && xPixel > 20){
                xPixel -= dots;
            }
            if (key == KeyEvent.VK_RIGHT && xPixel < ALL_DOTS){
                xPixel += dots;
            }
            if (key == KeyEvent.VK_UP && yPixel > 20){
                yPixel -= dots;
            }
            if (key == KeyEvent.VK_DOWN && yPixel < ALL_DOTS - 20 ){
                yPixel += dots;
            }

        }
    }

    private void circleChangeLineX() {
        if (rightC){
            rightC = false;
            leftC = true;
        }
        if(leftC){
            leftC = false;
            rightC = true;
        }
    }
}
