package com.company;

import java.awt.*;
public class MainLabaClass {
    //
    private int _startPosX ;
    private int _startPosY;
    //
    private int _pictureWidth;
    private int _pictureHeight;
    //
    private final int planeWidth = 150;
    private final int planeHeight = 100;
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


    public MainLabaClass(int maxSpeed, float weight, Color mainColor, Color dopColor)
    {

        MaxSpeed = 1000; //maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

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
                if (_startPosX + step + planeWidth < _pictureWidth)
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
                if (_startPosY + step + planeHeight < _pictureHeight)
                {
                    _startPosY += step;
                }
                break;
            }
        }
    }
    public void DrawTruck(Graphics g)
    {

        g.setColor(DopColor);
        g.fillOval(_startPosX,_startPosY, 250, 100);
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
