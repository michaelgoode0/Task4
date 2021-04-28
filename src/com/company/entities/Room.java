package com.company.entities;

import com.company.enums.Status;

import java.util.ArrayList;

public class Room {
    private Generator generator = new Generator();
    private int cost;
    private int id;
    private Status status;
    private int capacity;
    private int stars;
    private int clientId;
    public Room(){

    }

    public Room(int cost, int capacity, int stars){
        this.id=generator.generateUniqueId();
        this.cost=cost;
        this.capacity=capacity;
        this.stars=stars;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
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

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString(){
        return this.id +"," +this.cost + ","+ this.status + "," + this.capacity + "," + this.stars;
    }
}
