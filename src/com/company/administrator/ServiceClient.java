package com.company.administrator;

import com.company.dao.IClientDao;
import com.company.entities.Client;

public class ServiceClient {
    private IClientDao clientDao;
    void setClientDao(IClientDao clientDao){
        this.clientDao=clientDao;
    }

    public void addClient(Client client){
        clientDao.saveClient(client);
    }

}
