package com.company.console.actions;

import com.company.administrator.Administrator;
import com.company.entities.Room;
import com.company.enums.Status;

import java.util.Scanner;

public class CreateRoom implements IAction {

    private Administrator administrator;

    public CreateRoom(Administrator administrator){
        this.administrator=administrator;
    }

    @Override
    public void execute() {
        System.out.println("Enter new cost room: ");
        String cost = new Scanner(System.in).nextLine();
        System.out.println("Enter new capacity room: ");
        String capacity = new Scanner(System.in).nextLine();
        System.out.println("Enter new stars room: ");
        String stars = new Scanner(System.in).nextLine();

        Room room=new Room(Integer.parseInt(cost),Integer.parseInt(capacity),Integer.parseInt(stars));

        room.setStatus(Status.FREE);

        administrator.addRoom(room);

        System.out.printf("Executed create room with cost %s , capacity %s, stars %s, id %s" + System.lineSeparator(),room.getCost(),room.getCapacity(),room.getStars(),room.getId() );
    }
}
