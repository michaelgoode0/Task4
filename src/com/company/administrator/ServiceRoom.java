package com.company.administrator;

import com.company.comparator.CapacityComparator;
import com.company.comparator.CostComparator;
import com.company.comparator.StarsComparator;
import com.company.dao.IRoomDao;
import com.company.entities.Room;
import com.company.enums.Status;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class ServiceRoom {
    private IRoomDao roomDao;
    public void setRoomDao(IRoomDao roomDao){
        this.roomDao=roomDao;
    }

    public void delete(String number) throws IOException {
        int index = getIndex(number);
        if (index != -1) {
           roomDao.getListOfRooms().remove(index);
            System.out.printf("Удалена комната: %s" + "\n", number);
        } else System.out.println("Такой комнаты не существует");
    }

    private int getIndex(String number) throws IOException {
        for(var i :roomDao.getListOfRooms()) {
            if(i.getId().equals(number)) {
                return roomDao.getListOfRooms().indexOf(i);
            }
        }
        return -1;
    }
    public void changeCost(Room room, int cost) throws IOException {
        int index= roomDao.getListOfRooms().indexOf(room);
        if(cost>=0){
            roomDao.getListOfRooms().get(index).setCost(cost);
        }
        else System.out.println("Неверно указан номер или сумма");
    }
/*
    public void changeStatus(String number, Status status) throws IOException {
        int index=getIndex(number);
        roomDao.getListOfRooms().get(index).setStatus(status);
    }*/

    public void addRoom(Room room){
        roomDao.saveRoom(room);
    }

    public void getNumberOfFreeRooms() throws IOException {
        int p=0;
        for(var i:roomDao.getListOfRooms()){
            if(i.getStatus()==Status.FREE){
                p++;
            }
        }
        System.out.println(p);
    }
    public void sortByCost() throws IOException {
        roomDao.getListOfRooms().sort(new CostComparator());
        printRooms();
    }
    public void sortByCapacity() throws IOException {
        Collections.sort(roomDao.getListOfRooms(), new CapacityComparator());
        System.out.println("Sorted by capacity");
    }
    public void sortByStars() throws IOException {
        Collections.sort(roomDao.getListOfRooms(), new StarsComparator());
        System.out.println("Sorted by stars");
    }
    public void printRooms() throws IOException {
        for (var i:roomDao.getListOfRooms()){
            System.out.print(i.toString());
        }
    }

}
