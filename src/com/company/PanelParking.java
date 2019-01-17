package com.company;

import java.awt.Graphics;

import javax.swing.JPanel;


public class PanelParking extends JPanel {
    private Parking<Itruck> parking;

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            if (parking != null) {
                parking.Draw(g);
            }
        } catch (Exception ex) {
        }
    }
}