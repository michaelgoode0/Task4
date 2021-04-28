package com.company.initializer;


import com.company.administrator.Administrator;
import com.company.administrator.ServiceClient;
import com.company.administrator.ServiceRoom;
import com.company.administrator.ServiceService;
import com.company.console.Builder;
import com.company.console.MenuController;
import com.company.console.Navigator;
import com.company.dao.ClientDao;
import com.company.dao.RoomDao;
import com.company.dao.ServiceDao;
import com.company.fileworker.FileWorker;
import com.company.fileworker.Parser;

public class Initializer {
    String pathToClients = "C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/recourses/data/ClientData.csv";
    String pathToRooms = "C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/recourses/data/RoomData.csv";
    String pathToServices = "C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/recourses/data/ServiceData.csv";

    Parser parser = new Parser();
    FileWorker clientWorker = new FileWorker(pathToClients);
    FileWorker roomWorker = new FileWorker(pathToRooms);
    FileWorker serviceWorker = new FileWorker(pathToServices);

    ServiceService service = new ServiceService();
    ServiceRoom serviceRoom = new ServiceRoom();
    ServiceClient serviceClient = new ServiceClient();

    ClientDao clientDao = new ClientDao(parser,clientWorker);
    RoomDao roomDao = new RoomDao(parser,roomWorker);
    ServiceDao serviceDao = new ServiceDao(parser,serviceWorker);

    public void run() {
        service.setServiceDao(serviceDao);
        serviceClient.setClientDao(clientDao);
        serviceRoom.setRoomDao(roomDao);

        Administrator administrator = new Administrator(serviceClient, serviceRoom, service);
        MenuController menu = new MenuController(new Builder(administrator), new Navigator());
        menu.run();
    }
}

