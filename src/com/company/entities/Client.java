package com.company.entities;

public class Client {

    Generator generator= new Generator();

    private String name;
    private String dateOut;
    private int clientId;

    public Client(){

    }
    public Client(String name,String dateOut){
        this.clientId= 2;
        this.name=name;
        this.dateOut=dateOut;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String toString(){
        return this.name +","+this.dateOut+","+ this.clientId;
    }
}
