package com.company.initializer;

/*import com.company.administrator.Administrator;*/
import com.company.administrator.Administrator;
import com.company.administrator.ServiceClient;
import com.company.administrator.ServiceRoom;
import com.company.administrator.ServiceService;
import com.company.dao.*;
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

        serviceRoom.setRoomDao(new RoomDao());
        service.setServiceDao(new ServiceDao());
        serviceClient.setClientDao(new ClientDao());

        Client client1 = new Client("Kirill", "09.03.2014");
        Room room1 = new Room("KEKW", 3110, 50, 3);
        Room room2 = new Room("KEKOW", 200, 70, 5);
        Room room3 = new Room("Pog", 0, 8, 10);
        Service service = new Service("Завтрак", 100);

        administrator.addRoom(room1);
        administrator.addRoom(room2);
        administrator.addRoom(room3);
        administrator.addClient(client1,room1);
        administrator.getNumberOfFreeRooms();
        administrator.addService(service);

    }
}
