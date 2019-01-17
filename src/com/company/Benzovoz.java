package com.company;

import java.awt.*;
public class Benzovoz extends Truck {
    //
    public Color DopColor;// Äîïîëíèòåëüíûé öâåò

    public Color getDopColor() {
        return DopColor;
    }

    public void setDopColor(Color value) {
        DopColor = value;
    }



    public Benzovoz(int maxSpeed, float weight, Color mainColor,// Êîíñòðóêòîð
                        Color dopColor) {
        super(maxSpeed, weight, mainColor);
        DopColor = dopColor;

    }
    public void DrawTruck(Graphics g)
    {

        g.setColor(DopColor);
        g.fillOval(_startPosX,_startPosY, 250, 100);
        g.setColor(getMainColor());
        g.fillRect(_startPosX,_startPosY+90, 320, 50);
        g.fillRect(_startPosX+215, _startPosY, 50,115);

        g.setColor(Color.BLACK);
        g.fillOval(_startPosX+20,_startPosY+138, 50, 50);
        g.fillOval(_startPosX+240,_startPosY+138, 50, 50);
        g.fillOval(_startPosX+75,_startPosY+138, 50, 50);

        g.setColor(Color.RED);
        g.fillRect(_startPosX,_startPosY+90, 15, 15);

        g.setColor(Color.YELLOW);
        g.fillRect(_startPosX+300,_startPosY+90, 20, 20);

        g.setColor(Color.ORANGE);
        g.fillRect(_startPosX+230, _startPosY-20, 20,20);

    }
}
