package com.company.console.actions;

import com.company.administrator.Administrator;
import com.company.entities.Room;
import com.company.fileworker.Parser;

import java.util.List;

public class PrintListOfRooms implements IAction{
    private Administrator administrator;

    public PrintListOfRooms(Administrator administrator){
        this.administrator=administrator;
    }

    @Override
    public void execute() throws Exception {
        List<Room> rooms = administrator.getListOfRooms();
        for(var i:rooms){
            System.out.printf("ID: %d, Cost: %d, Status: %s, Capacity: %d, Stars: %d" + "\n", i.getId(),i.getCost(),i.getStatus(),i.getCapacity(),i.getStars());
        }
    }
}
