package com.company.interfaces;

import com.company.enums.Status;

public interface IWorker {
    void add(String number,int cost,int capacity,int stars);
    void delete(String number);
    void changeCost(String number, int cost);
    void changeStatus(String number, Status status);
    void addRoomOrService();
    void showRooms();
    void sortByCost();
    void sortByCapacity();
    void sortByStars();
}
