package com.company.dao;

import com.company.entities.Client;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClientDao implements IClientDao {

    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/keeper/ClientData.txt";

    public void saveClient(ArrayList<Client> clients) {
        try (FileWriter out = new FileWriter(path)) {
            for (var item: clients) {
                out.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
