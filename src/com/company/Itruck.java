package com.company;

import java.awt.*;

public interface Itruck {

    void DrawTruck(Graphics g);

    void MoveTransport(Direction direction);

    void SetPosition(int i, int i1, int width, int height);
}