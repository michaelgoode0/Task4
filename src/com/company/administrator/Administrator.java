package com.company.administrator;

import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;

public class Administrator {
    private ServiceClient serviceClient=new ServiceClient();
    private ServiceRoom serviceRoom = new ServiceRoom();
    private ServiceService serviceService=new ServiceService();

     public void addRoom(Room room){
         serviceRoom.addRoom(room);
     }
     public void addClient(Client client, Room room){
         serviceClient.addClient(client,room);
     }
     public void showRooms(){
         serviceRoom.showRooms();
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
