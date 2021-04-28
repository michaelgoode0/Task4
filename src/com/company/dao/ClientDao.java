package com.company.dao;

import com.company.entities.Client;
import com.company.fileworker.FileWorker;
import com.company.fileworker.Parser;

import java.io.IOException;
import java.util.*;

public class ClientDao implements IClientDao {
    private Parser parser;
    private FileWorker fileWorker;
    private String path = "C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/recourses/data/ClientData.csv";

    public ClientDao(Parser parser, FileWorker fileWorker){
        this.fileWorker=fileWorker;
        this.parser=parser;
    }



    @Override
    public void saveClient(Client client) {
        fileWorker.writeInFile(client.toString(), true);
    }
    @Override
    public List<Client> getListOfClients() throws IOException {
        List<Client> clients = parser.parseClients(path);
        return clients;
    }


    @Override
    public void update(Client client) throws Exception {
        List<Client> clients = getListOfClients();
        for (var i : clients) {
            if (i.getName().equals(client.getName())) {
                var index = clients.indexOf(i);
                clients.set(index, client);
            } else {
                System.out.println("Client not found");
            }
        }
        StringBuffer update = new StringBuffer();
        for (var i : clients) {
            update.append(i.toString()).append("\n");
        }
        fileWorker.writeInFile(update.toString(), false);
    }
}