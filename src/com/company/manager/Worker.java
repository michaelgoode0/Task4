package com.company.manager;

import com.company.comparator.CapacityComparator;
import com.company.comparator.StarsComparator;
import com.company.entities.Hotel;
import com.company.entities.Room;
import com.company.enums.Status;
import com.company.comparator.CostComparator;
import com.company.interfaces.IWorker;

import java.lang.reflect.Array;
import java.util.*;

import static com.company.enums.Status.SERVED;

public class Worker implements IWorker  {
    Hotel hotel=new Hotel();
    ArrayList <Room> rooms= hotel.getRooms();

    public Worker(){

    }
    public void add(String number,int cost,int capacity,int stars){
        Room room=new Room(number,cost,capacity,stars);
        rooms.add(room);

    }
    public void delete(String number){
        int index = getIndex(number);
        rooms.remove(index);
    }

    public void changeCost(String number, int cost){
        int index=getIndex(number);
        rooms.get(index).setCost(cost);
    }

    public void changeStatus( String number,Status status){
        int index=getIndex(number);
        rooms.get(index).setStatus(status);
    }

    private int getIndex(String number){
        for(var i :rooms) {
            if(i.getNumber().equals(number))
                return rooms.indexOf(i);
        }
        return -1;
    }

    public void addRoomOrService(){

    }
    private void print(){
        for(var i:rooms){
            System.out.printf("Номер комнаты %s , Статус комнаты %s , Стоимость комнаты %d ,Вместимость: %d,Кол-во звёзд %d \n",i.getNumber(),i.getStatus(),i.getCost(),i.getCapacity(),i.getStars());
        }
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
        System.out.println("Sorted by cost");
        print();
    }
    public void sortByStars(){
        Collections.sort(rooms, new StarsComparator());
        System.out.println("Sorted by cost");
        print();
    }



}
