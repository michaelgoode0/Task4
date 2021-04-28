package com.company.administrator;

import com.company.dao.IClientDao;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.enums.Status;

import java.io.IOException;
import java.util.List;

public class ServiceClient {
    private IClientDao clientDao;

    public void setClientDao(IClientDao clientDao){
        this.clientDao=clientDao;
    }

    public void addClientToRoom(Client client, Room room){
        if(room.getStatus()==Status.FREE) {
            System.out.println(client.getClientId());
            room.setClientId(client.getClientId());
            System.out.println(room.getClientId());
            clientDao.saveClient(client);
            System.out.printf("Executed add client with name:  %s to room %s" + System.lineSeparator(),client.getName(),room.getId() );
        }
        else {
            System.out.println("Another client already attached to this room");
        }
    }
    public void deleleClient(Client client, Room room) throws IOException {
        room.setStatus(Status.FREE);
        clientDao.getListOfClients().remove(client);
    }

    public List<Client> getListOfClients() throws IOException {
        List<Client> clients= clientDao.getListOfClients();
        return clients;
    }

}
