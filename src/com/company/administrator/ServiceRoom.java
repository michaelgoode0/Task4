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

    public void delete(String number) {
        int index = getIndex(number);
        if (index != -1) {
           Hotel.getHotel().getRooms().remove(index);
            System.out.printf("Удалена комната: %s" + "\n", number);
        } else System.out.println("Такой комнаты не существует");
    }

    private int getIndex(String number){
        for(var i :Hotel.getHotel().getRooms()) {
            if(i.getId().equals(number)) {
                return Hotel.getHotel().getRooms().indexOf(i);
            }
        }
        return -1;
    }
    public void changeCost(String number, int cost){
        int index = getIndex(number);
        if(cost>=0|| index!=-1){
            Hotel.getHotel().getRooms().get(index).setCost(cost);
        }
        else System.out.println("Неверно указан номер или сумма");
    }

    public void changeStatus(String number, Status status){
        int index=getIndex(number);
        Hotel.getHotel().getRooms().get(index).setStatus(status);
    }

    public void addRoom(Room room){
        Hotel.getHotel().getRooms().add(room);
    }

    public void getNumberOfFreeRooms(){
        int p=0;
        for(var i:Hotel.getHotel().getRooms()){
            if(i.getStatus()==Status.FREE){
                p++;
            }
        }
        System.out.println(p);
    }
    public void sortByCost(){
        Collections.sort(Hotel.getHotel().getRooms(), new CostComparator());
        System.out.println("Sorted by cost");
    }
    public void sortByCapacity(){
        Collections.sort(Hotel.getHotel().getRooms(), new CapacityComparator());
        System.out.println("Sorted by capacity");
    }
    public void sortByStars(){
        Collections.sort(Hotel.getHotel().getRooms(), new StarsComparator());
        System.out.println("Sorted by stars");
    }
}
