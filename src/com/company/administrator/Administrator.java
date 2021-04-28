package com.company.administrator;

import com.company.dao.ClientDao;
import com.company.dao.IClientDao;
import com.company.dao.RoomDao;
import com.company.dao.ServiceDao;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;

import java.io.IOException;
import java.util.List;

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

     public void updateRoom(Room room) throws Exception {
        serviceRoom.updateRoom(room);
     }
     public void addClient(Client client,Room room){
         serviceClient.addClientToRoom(client,room);
     }

     public void addService(Service service){
         serviceService.addService(service);
     }

     public Room getById(int roomId) throws IOException {
        return serviceRoom.get(roomId);
     }
     public List<Room> getListOfRooms() throws IOException {
        List<Room> rooms = serviceRoom.getListOfRooms();
        return rooms;
     }



}
