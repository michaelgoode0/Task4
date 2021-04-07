package com.company.comparator;

import com.company.entities.Room;

import java.util.Comparator;

public class StarsComparator implements Comparator<Room> {
    public int compare(Room r1, Room r2){
        return r1.getStars() - r2.getStars();
    }
}