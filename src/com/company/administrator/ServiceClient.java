package com.company.administrator;

import com.company.entities.Client;
import com.company.entities.Hotel;
import com.company.entities.Room;
import com.company.enums.Status;

import java.util.*;



public class ServiceClient {
    private Map<Client,Room> list=new HashMap<>();

    public void addClient(Client client, Room room) {
        room.setStatus(Status.SERVED);
        list.put(client,room);
        Hotel.getHotel().getClients().add(client);
    }

    public void deleteClient(Client client,Room room){
        room.setStatus(Status.FREE);
        list.remove(client);
    }

    public void printList(){
        for(var item : list.entrySet()){
            System.out.printf("Имя : %s  Номер: %s Дата освободения: %s \n", item.getKey().getName(), item.getValue().getId(),item.getKey().getDateOut().getTime());
        }

    }
    public Map<Client, Room> getList() {
        return list;
    }

    public void getNumberOfClients(){
       System.out.println(list.size());
    }

}
