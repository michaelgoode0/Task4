package com.company.administrator;

import com.company.dao.ClientDao;
import com.company.dao.IClientDao;
import com.company.dao.RoomDao;
import com.company.dao.ServiceDao;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;

import java.io.IOException;

public class Administrator {

    private final ServiceClient serviceClient;
    private final ServiceRoom serviceRoom;
    private final ServiceService serviceService;

    public Administrator(ServiceClient serviceClient, ServiceRoom serviceRoom, ServiceService service){
        this.serviceService=service;
        this.serviceClient=serviceClient;
        this.serviceRoom=serviceRoom;
    }


     public void addRoom(Room room){
         serviceRoom.addRoom(room);
     }
     public void addClient(Client client,Room room){
         serviceClient.addClient(client, room);
     }
     public void changeCost(Room room,int cost) throws IOException {
         serviceRoom.changeCost(room,cost);
     }
     public void getNumberOfFreeRooms() throws IOException {
         serviceRoom.getNumberOfFreeRooms();
     }
     public void sortByCost() throws IOException {
        serviceRoom.sortByCost();
     }
     public void addService(Service service){
         serviceService.addService(service);
     }

}
