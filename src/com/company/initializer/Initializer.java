package com.company.initializer;

import com.company.administrator.Administrator;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Initializer {
    Administrator administrator=new Administrator();
    public Initializer(){
        Calendar calendar=new GregorianCalendar();
        calendar.set(2020,6,25);
        Client client1=new Client("Kirill",calendar);
        Room room1=new Room("1",100,50,3);
        Room room2=new Room("2",200,50,5);
        Service service= new Service("Завтрак", 100);
        administrator.addRoom(room1);
        administrator.addRoom(room2);
        administrator.addClient(client1,room1);
        administrator.changeCost("1",500);
        administrator.getListOfClients();
        administrator.getNumberOfClients();
        administrator.getNumberOfFreeRooms();
        administrator.addService(service);
        administrator.addServiceToClient(client1,service);
        administrator.showServices();
        administrator.exportData();

    }

}
