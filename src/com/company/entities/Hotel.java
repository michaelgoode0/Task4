package com.company.entities;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Client> clients;
    private ArrayList<Service> services;
    private static Hotel hotel;
    private ArrayList <Room>rooms;

    private Hotel(){
        rooms=new ArrayList<>();
        clients=new ArrayList<>();
        services=new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    public static Hotel getHotel(){
        if(hotel==null){
            hotel=new Hotel();
        }
        return hotel;
    }

}
