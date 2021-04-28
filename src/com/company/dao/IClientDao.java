package com.company.dao;



import com.company.entities.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IClientDao {
    void saveClient(Client client);

    List<Client> getListOfClients() throws IOException;

    void update(Client client) throws Exception;

}
