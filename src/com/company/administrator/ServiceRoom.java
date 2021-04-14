package com.company.administrator;

import com.company.comparator.CapacityComparator;
import com.company.comparator.CostComparator;
import com.company.comparator.StarsComparator;
import com.company.entities.Hotel;
import com.company.entities.Room;
import com.company.enums.Status;

import java.util.ArrayList;
import java.util.Collections;

public class ServiceRoom {
    private Hotel hotel = Hotel.getHotel();
    private ArrayList<Room> rooms= hotel.getRooms();
    public void delete(String number) {
        int index = getIndex(number);
        if (index != -1) {
            rooms.remove(index);
            System.out.printf("Удалена комната: %s" + "\n", number);
        } else System.out.println("Такой комнаты не существует");
    }

    private int getIndex(String number){
        for(var i :rooms) {
            if(i.getId().equals(number)) {
                return rooms.indexOf(i);
            }
        }
        return -1;
    }
    public void changeCost(String number, int cost){
        int index = getIndex(number);
        if(cost>=0|| index!=-1){
            rooms.get(index).setCost(cost);
        }
        else System.out.println("Неверно указан номер или сумма");
    }

    public void changeStatus(String number, Status status){
        int index=getIndex(number);
        rooms.get(index).setStatus(status);
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    private void print(){
        for(var i:rooms){
            System.out.printf("Номер комнаты %s , Статус комнаты %s , Стоимость комнаты %d ,Вместимость: %d,Кол-во звёзд %d \n",i.getId(),i.getStatus(),i.getCost(),i.getCapacity(),i.getStars());
        }
    }

    public void getNumberOfFreeRooms(){
        int p=0;
        for(var i:rooms){
            if(i.getStatus()==Status.FREE){
                p++;
            }
        }
        System.out.println(p);
    }
    public void showRooms(){
        System.out.println("List of rooms");
        print();
    }
    public void sortByCost(){
        Collections.sort(rooms, new CostComparator());
        System.out.println("Sorted by cost");
        print();

    }
    public void sortByCapacity(){
        Collections.sort(rooms, new CapacityComparator());
        System.out.println("Sorted by capacity");
        print();
    }
    public void sortByStars(){
        Collections.sort(rooms, new StarsComparator());
        System.out.println("Sorted by stars");
        print();
    }
}
