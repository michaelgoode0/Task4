package com.company.console.actions;

import com.company.administrator.Administrator;
import com.company.entities.Client;
import com.company.entities.Room;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GetInfoRoomById implements IAction{
    private Administrator administrator;

    public GetInfoRoomById(Administrator administrator){
        this.administrator=administrator;
    }
  /*  public Client get(Room room) throws IOException {

        List<Client> clients=administrator.getListOfClients();
        for (var i :clients){
            if(i.getClientId()==room.getClientId()){
                return i;
            }
        }
        return null;
    }*/

    @Override
    public void execute() throws Exception {
        System.out.println("Enter room id");
        String roomId = new Scanner(System.in).nextLine();
        Room room = administrator.getById(Integer.parseInt(roomId));
        System.out.printf("ID: %d, Cost: %d, Status: %s, Capacity: %d, Stars: %d" + "\n", room.getId(),room.getCost(),room.getStatus(),room.getCapacity(),room.getStars());
    }
}
