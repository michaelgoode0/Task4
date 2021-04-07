package com.company.entities;

import com.company.enums.Status;

public class Room {
    private int cost;
    private String number;
    private Status status;
    private int capacity;
    private int stars;

    public Room(String number,int cost,int capacity, int stars){
        this.number=number;
        this.cost=cost;
        this.status=Status.FREE;
        this.capacity=capacity;
        this.stars=stars;
    }
    public Room(){

    }

    public String getNumber() {
        return number;
    }

    public Status getStatus() {
        return status;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStars() {
        return stars;
    }
}
