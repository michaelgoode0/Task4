package com.company.entities;

import java.util.ArrayList;

public class Hotel {
    private static Hotel hotel;
    private ArrayList <Room>rooms;

    private Hotel(){
        rooms=new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public static Hotel getHotel(){
        if(hotel==null){
            hotel=new Hotel();
        }
        return hotel;
    }

}
