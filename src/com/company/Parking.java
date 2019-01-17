package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Color;
import java.awt.Graphics;

public class Parking<T extends Itruck> {
    private HashMap<Integer, T> _places;//Ìàññèâ îáúåêòîâ, êîòîðûå õðàíèì
    private int _maxCount;
    private int PictureWidth;//Øèðèíà îêíà îòðèñîâêè

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

    public Parking(int size, int pictureWidth, int pictureHeight) { // Êîíñòðóêòîð
        _maxCount = size;
        _places = new HashMap<Integer, T>();
        this.PictureWidth = PictureWidth;
        this.PictureHeight = PictureHeight;
    }

    public int addTransport(T truck) {
        if (_places.size() == _maxCount) {
            return -1;
        }
        for (int i = 0; i < _maxCount; i++) {
            if (checkFreePlace(i)) {
                _places.put(i, truck);
                _places.get(i).SetPosition(5 + i / 5 * _placeSizeWidth + 5,
                        i % 5 * _placeSizeHeight + 15, PictureWidth,
                        PictureHeight);
                return i;
            }
        }
        return -1;
    }

    public T removeTransport(int index) {
        if (!checkFreePlace(index)) {
            T transport = _places.get(index);
            _places.remove(index);
            return transport;
        }
        return null;
    }

    private boolean checkFreePlace(int index) {// / Ìåòîä ïðîâåðêè çàïîëíåíîñòè
        // ïàðêîâî÷íîãî ìåñòà (ÿ÷åéêè
        // ìàññèâà)
        return !_places.containsKey(index);
    }

    public void Draw(Graphics g) {// / Ìåòîä îòðèñîâêè ïàðêîâêè
        DrawMarking(g);
        for (T truck : _places.values()) {
            truck.DrawTruck(g);
        }
    }

    private void DrawMarking(Graphics g)// / Ìåòîä îòðèñîâêè ðàçìåòêè
    // ïàðêîâî÷íûõ ìåñò
    {
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, (_maxCount / 5) * _placeSizeWidth, 480);// ãðàíèöû
        // ïðàêîâêè
        for (int i = 0; i < _maxCount / 5; i++) {// îòðèñîâûâàåì, ïî 5 ìåñò
            // íà ëèíèè
            for (int j = 0; j < 6; ++j) {
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i
                        * _placeSizeWidth + 110, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
        }
    }

}