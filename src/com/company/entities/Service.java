package com.company.entities;


public class Service {
    private String name;
    private int cost;

    public Service(){

    }
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
        return this.name + "," + this.cost;
    }
}
