package com.company.fileworker;

import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;
import com.company.enums.Status;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public String getString(String path) throws IOException {
        StringBuffer string = new StringBuffer();
        Path path1 = FileSystems.getDefault().getPath(path);
        Files.lines(path1).forEach(k -> string.append(k).append("\n"));
        return string.toString();
    }
    public List<Client> parseClients(String path) throws IOException {
        String[] items= getString(path).split("\n");
        List<Client> clients= new ArrayList<>();
        for(var item:items){
            if(!item.equals("")){
                String[] values=item.split(String.valueOf(","));
                clients.add(convertToClient(values));
            }
        }
        return clients;
    }
    public Client convertToClient(String []values){
        Client client=new Client();
        client.setClientId(Integer.parseInt(values[2]));
        client.setName(values[0]);
        client.setDateOut(values[1]);
        return client;
    }

    public List<Room> parseRooms(String path) throws IOException {
        String[] items= getString(path).split("\n");
        List<Room> rooms = new ArrayList<>();
        for(var item:items){
            if(!item.equals("")){
                String[] values=item.split(String.valueOf(","));
                rooms.add(convertToRoom(values));
            }
        }
        return rooms;
    }
    public Room convertToRoom(String[] values){
        Room room = new Room();
        room.setId(Integer.parseInt(values[0]));
        room.setCost(Integer.parseInt(values[1]));
        room.setStatus(Status.valueOf(values[2]));
        room.setCapacity(Integer.parseInt(values[3]));
        room.setStars(Integer.parseInt(values[4]));
        return room;
    }
    public List<Service> parseServices(String path) throws IOException {
        String [] items = getString(path).split("\n");
        List<Service> services = new ArrayList<>();
        for(var item:items){
            if(!item.equals("")){
                String[] values=item.split(String.valueOf(","));
                services.add(convertToService(values));
            }
        }
        return services;
    }
    public Service convertToService(String[] values){
        Service service=new Service();
        service.setName(values[0]);
        service.setCost(Integer.parseInt(values[1]));
        return service;
    }

}
