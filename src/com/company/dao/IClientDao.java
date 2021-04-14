package com.company.dao;



import com.company.entities.Client;

import java.util.ArrayList;

public interface IClientDao {
    void saveClient(ArrayList<Client> clients);
}
