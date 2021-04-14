package com.company.administrator;

import com.company.dao.ClientDao;
import com.company.dao.IClientDao;
import com.company.dao.RoomDao;
import com.company.dao.ServiceDao;
import com.company.entities.Client;
import com.company.entities.Hotel;
import com.company.entities.Room;
import com.company.entities.Service;

public class Administrator {

    private final ServiceClient serviceClient=new ServiceClient();
    private final ServiceRoom serviceRoom = new ServiceRoom();
    private final ServiceService serviceService=new ServiceService();
    private final ClientDao clientDao= new ClientDao();
    private final RoomDao roomDao= new RoomDao();
    private final ServiceDao serviceDao = new ServiceDao();

    public void exportData(){
        clientDao.saveClient(Hotel.getHotel().getClients());
        roomDao.saveRooms(Hotel.getHotel().getRooms());
        serviceDao.saveServices(Hotel.getHotel().getServices());
    }

     public void addRoom(Room room){
         serviceRoom.addRoom(room);
     }
     public void addClient(Client client, Room room){
         serviceClient.addClient(client,room);
     }
     public void changeCost(String id,int cost){
         serviceRoom.changeCost(id,cost);
     }
     public void deleteClient(Client client,Room room){
         serviceClient.deleteClient(client,room);
     }
     public void getListOfClients(){
         serviceClient.printList();
     }
     public void getNumberOfClients(){
         serviceClient.getNumberOfClients();
     }
     public void getNumberOfFreeRooms(){
         serviceRoom.getNumberOfFreeRooms();
     }
     public void addService(Service service){
         serviceService.addService(service);
     }
     public void showServices(){
         serviceService.showServices();
     }
     public void addServiceToClient(Client client,Service service){
         serviceService.addServiceToClient(client,service);
     }


}
