package com.company.administrator;

import com.company.entities.Client;
import com.company.entities.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ServiceService {
    private ArrayList<Service> services=Service.getServices();
    private  Map<Client,Service> listOfServices = new HashMap<>();

    public void addService(Service service){
        services.add(service);
    }

    public void addServiceToClient(Client client, Service service){
        listOfServices.put(client,service);
    }

    public void showServices(){
        for(var item : listOfServices.entrySet()){
            System.out.printf("Имя : %s  Сервис: %s Стоимость сервиса: %s\n", item.getKey().getName(), item.getValue().getName() , item.getValue().getCost());
        }
    }
}
