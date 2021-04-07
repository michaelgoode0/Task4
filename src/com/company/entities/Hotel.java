package com.company.entities;

import java.util.ArrayList;

public class Hotel {
    private ArrayList <Room>rooms;

    public Hotel(){
        rooms=new ArrayList<Room>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
