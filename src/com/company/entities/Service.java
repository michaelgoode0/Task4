package com.company.entities;

import java.util.ArrayList;

public class Service {
    private String name;
    private int cost;

    public Service(String name, int cost){
        this.cost=cost;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Name "+ this.name + " | Cost " + this.cost;
    }
}
