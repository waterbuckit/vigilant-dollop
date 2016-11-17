/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aims;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author waterbucket
 */
public class StatusBar extends JPanel {

    GridLayout statusLayout;
    JLabel timeLabel;
    CurrentTime timeCurrent;
    SeparatorPanel sepPanel;

    public StatusBar() {
        statusLayout = new GridLayout(1, 0, 1, 1);
        timeLabel = new JLabel();
        timeCurrent = new CurrentTime();
        sepPanel = new SeparatorPanel(Color.lightGray, Color.lightGray);
        initialiseComponents();
    }

    private void initialiseComponents() {
        this.add(timeLabel);
        this.add(sepPanel);
        this.setLayout(statusLayout);
        this.timeCurrent.getTime();
    }

    //getting the current time;
    class CurrentTime {

        Timer timer;
        Calendar calend;
        SimpleDateFormat sdf;

        public CurrentTime() {
            sdf = new SimpleDateFormat("HH:mm");
        }

        private void getTime() {
            timer = new Timer(1000, (ActionEvent ae) -> {
                calend = Calendar.getInstance();
                timeLabel.setText(sdf.format(calend.getTime()));
            });
            timer.start();
        }
    }

    class SeparatorPanel extends JPanel {

        protected Color leftColor;
        protected Color rightColor;

        public SeparatorPanel(Color leftColor, Color rightColor) {
            this.leftColor = leftColor;
            this.rightColor = rightColor;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(leftColor);
            g.drawLine(0, 0, 0, getHeight());
            g.setColor(rightColor);
            g.drawLine(1, 0, 1, getHeight());
        }

    }

}