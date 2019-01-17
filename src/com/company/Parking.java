package com.company;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class Parking<T extends Itruck> {
    ArrayList<T> _places;// / Ìàññèâ îáúåêòîâ, êîòîðûå õðàíèì

    private int PictureWidth;// / Øèðèíà îêíà îòðèñîâêè

    public int getPictureWidth() {
        return PictureWidth;
    }

    public void setPictureWidth(int value) {
        PictureWidth = value;
    }

    private int PictureHeight;// / Âûñîòà îêíà îòðèñîâêè

    public int getPictureHeight() {
        return PictureHeight;
    }

    public void setPPictureHeighth(int value) {
        PictureHeight = value;
    }

    private int _placeSizeWidth = 360;// / Ðàçìåð ïàðêîâî÷íîãî ìåñòà (øèðèíà)
    private int _placeSizeHeight = 200;// / Ðàçìåð ïàðêîâî÷íîãî ìåñòà (âûñîòà)

    public Parking(int size, int PictureWidth, int PictureHeight) {// /
        // Êîíñòðóêòîð
        _places = new ArrayList<T>(size);
        this.PictureWidth = PictureWidth;
        this.PictureHeight = PictureHeight;
        for (int i = 0; i < size; i++) {
            _places.add(null);
        }
    }

    public int addTransport(T truck) {
        for (int i = 0; i < _places.size(); i++) {
            if (checkFreePlace(i)) {
                _places.add(i, truck);
                _places.get(i).SetPosition(5 + i / 5 * _placeSizeWidth + 5,
                        i % 5 * _placeSizeHeight + 15, PictureWidth,
                        PictureHeight);
                return i;
            }
        }
        return -1;
    }

    public T removeTransport(int index) {
        if (index < 0 || index > _places.size()) {
            return null;
        }
        if (!checkFreePlace(index)) {
            T car = _places.get(index);
            _places.set(index, null);
            return car;
        }
        return null;
    }

    private boolean checkFreePlace(int index) {
        return _places.get(index) == null;
    }

    public void Draw(Graphics g) {// / Ìåòîä îòðèñîâêè ïàðêîâêè
        DrawTruck(g);
        for (int i = 0; i < _places.size(); i++) {
            if (!checkFreePlace(i)) {
                _places.get(i).DrawTruck(g);
            }
        }
    }

    private void DrawTruck(Graphics g)// / Ìåòîä îòðèñîâêè ðàçìåòêè
    // ïàðêîâî÷íûõ ìåñò
    {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, (_places.size() / 5) * _placeSizeWidth, 480);// ãðàíèöû
        // ïðàêîâêè
        for (int i = 0; i < _places.size() / 5; i++) {
            for (int j = 0; j < 6; ++j) {
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i
                        * _placeSizeWidth + 110, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
    }

}