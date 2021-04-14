package com.company.entities;

import java.util.ArrayList;

public class Service {
    private static ArrayList<Service> services=new ArrayList<>();
    private String name;
    private int cost;

    public Service(String name, int cost){
        this.cost=cost;
        this.name=name;
    }
    public static ArrayList<Service> getServices(){
        return services;
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
}
