package com.company.console.actions;

import com.company.administrator.Administrator;
import com.company.entities.Client;
import com.company.entities.Generator;
import com.company.entities.Room;
import com.company.enums.Status;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Scanner;

public class AddClientToRoom implements IAction {
    private Administrator administrator;

    public AddClientToRoom(Administrator administrator){
        this.administrator=administrator;
    }

    @Override
    public void execute() throws Exception {
        System.out.println("Enter name of client: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter date out");
        String dateOut= new Scanner(System.in).nextLine();
        System.out.println("Enter id of room");
        String id=new Scanner(System.in).nextLine();
        Room room=administrator.getById(Integer.parseInt(id));

        Client client = new Client();
        client.setName(name);
        client.setDateOut(dateOut);
        client.setClientId(new Generator().generateUniqueId());
        administrator.addClient(client,room);
        if(room.getStatus()==Status.FREE){
            room.setStatus(Status.SERVED);
        }
        administrator.updateRoom(room);


    }
}
