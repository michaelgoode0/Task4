package com.company.administrator;

import com.company.dao.IClientDao;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.enums.Status;

import java.io.IOException;

public class ServiceClient {
    private IClientDao clientDao;

    public void setClientDao(IClientDao clientDao){
        this.clientDao=clientDao;
    }

    public void addClient(Client client, Room room){
        clientDao.saveClient(client);
    }
    public void deleleClient(Client client, Room room) throws IOException {
        room.setStatus(Status.FREE);
        clientDao.getListOfClients().remove(client);
    }

}
