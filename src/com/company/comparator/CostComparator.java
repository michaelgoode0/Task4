package com.company.comparator;

import com.company.entities.Room;

import java.util.Comparator;

public class CostComparator implements Comparator<Room> {
    public int compare(Room r1, Room r2){
        return r1.getCost() - r2.getCost();
    }
}