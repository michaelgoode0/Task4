package com.company.entities;


public class Service {

    Generator generator=new Generator();

    private String name;
    private int cost;
    private int serviceId;

    public Service(){

    }
    public Service(String name, int cost){
        this.serviceId=generator.generateUniqueId();
        this.cost=cost;
        this.name=name;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
