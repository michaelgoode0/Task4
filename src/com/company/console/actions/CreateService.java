package com.company.console.actions;

import com.company.administrator.Administrator;
import com.company.administrator.ServiceClient;
import com.company.entities.Service;

import java.util.Scanner;

public class CreateService implements IAction {
    private Administrator administrator;

    public CreateService(Administrator administrator){
        this.administrator=administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter new name of service: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter new cost of service: ");
        String cost = new Scanner(System.in).nextLine();

        Service service= new Service();
        service.setName(name);
        service.setCost(Integer.parseInt(cost));

        administrator.addService(service);

        System.out.printf("Executed create service with id %s , name %s, cost %s" + System.lineSeparator(),service.getServiceId(),service.getName(),service.getCost());
    }
}
