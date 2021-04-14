package com.company.dao;

import com.company.entities.Client;
import com.company.entities.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServiceDao implements IServiceDao {
    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/keeper/ServiceData.txt";

    public void saveServices(ArrayList<Service> services) {
        try (FileWriter out = new FileWriter(path)) {
            for (var item: services) {
                out.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
