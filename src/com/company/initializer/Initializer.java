package com.company.initializer;

/*import com.company.administrator.Administrator;*/
import com.company.administrator.Administrator;
import com.company.administrator.ServiceClient;
import com.company.administrator.ServiceRoom;
import com.company.administrator.ServiceService;
import com.company.dao.ClientDao;
import com.company.dao.RoomDao;
import com.company.dao.ServiceDao;
import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;

import java.io.IOException;


public class Initializer {
    ServiceService service = new ServiceService();
    ServiceRoom serviceRoom = new ServiceRoom();
    ServiceClient serviceClient = new ServiceClient();

    Administrator administrator = new Administrator(serviceClient, serviceRoom, service);

    public Initializer(){

    }
    public void run() throws IOException {
        /*Client client1 = new Client("Kirill", "09.03.2014");
        Room room1 = new Room("1", 100, 50, 3);
        Room room2 = new Room("2", 200, 50, 5);
        Service service = new Service("Завтрак", 100);

        administrator.addRoom(room1);
        administrator.addRoom(room2);
        administrator.changeCost("1", 500);
        administrator.getNumberOfFreeRooms();
        administrator.addService(service);*/
    }
}
