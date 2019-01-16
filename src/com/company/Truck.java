package com.company;

import java.awt.*;

public class Truck extends Vehicle {
    //
    protected int _startPosX ;
    protected int _startPosY;
    //

    //
    protected final int truckWidth = 175;
    protected final int truckHeight = 100;
    //
    private int MaxSpeed;
    private float Weight;
    private Color MainColor;
    private Color DopColor;
    public int getMaxSpeed() {
        return MaxSpeed;
    }
    public float getWeight() {
        return Weight;
    }
    public Color getMainColor() {
        return MainColor;
    }
    public Color getDopColor() {
        return DopColor;
    }

    //
    public Truck(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {

        MaxSpeed = maxSpeed; //maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
    }

    //

    @Override
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Left:
            {
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            }
            case Right:
            {
                if (_startPosX + step + truckWidth < _pictureWidth)
                {
                    _startPosX += step;
                }
                break;
            }
            case Up:
            {
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            }
            case Down:
            {
                if (_startPosY + step + truckHeight < _pictureHeight)
                {
                    _startPosY += step;
                }
                break;
            }
        }
    }


    public void DrawTruck(Graphics g)
    {
        //
        g.setColor(MainColor);
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