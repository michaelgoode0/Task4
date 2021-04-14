package com.company.entities;

import com.company.enums.Status;

import java.util.ArrayList;

public class Room {
    private int cost;
    private String id;
    private Status status;
    private int capacity;
    private int stars;

    public Room(String id, int cost, int capacity, int stars){
        this.id = id;
        this.cost=cost;
        this.status=Status.FREE;
        this.capacity=capacity;
        this.stars=stars;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
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

    public String toString(){
        return "ID "+this.id + " Stars " + this.stars + " Status "+ this.status + " Capacity " + this.capacity + " Cost " + this.cost;
    }
}
