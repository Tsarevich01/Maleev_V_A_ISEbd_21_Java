package com.company;

import java.util.ArrayList;

public class MultiLevelParking {

    ArrayList<Parking<Itruck>> parkingStages;// / Ñïèñîê ñ óðîâíÿìè ïàðêîâêè
    private final int countPlaces = 3; // / Ñêîëüêî ìåñò íà êàæäîì óðîâíå

    //Êîíñòðóêòîð
    public MultiLevelParking(int countStages, int pictureWidth,
                             int pictureHeight) {
        parkingStages = new ArrayList<Parking<Itruck>>();
        for (int i = 0; i < countStages; ++i) {
            parkingStages.add(new Parking<Itruck>(countPlaces,
                    pictureWidth, pictureHeight));
        }
    }
    //(Èíäåêñàòîð)
    public Parking<Itruck> getParking(int index) {
        if ((index > -1) && (index < parkingStages.size())) {
            return parkingStages.get(index);
        }
        return null;
    }
}