package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

import javax.swing.JPanel;
public class PanelForPaint extends JPanel {

    private Itruck truck;



    public void setTruck(Itruck truck) {
        this.truck = truck;
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (truck != null) {
            truck.DrawTruck(g);
        }
    }
}