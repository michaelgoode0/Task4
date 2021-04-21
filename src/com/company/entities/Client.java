package com.company.entities;

public class Client {

    private String name;
    private String dateOut;

    public Client(){

    }
    public Client(String name,String dateOut){
        this.name=name;
        this.dateOut=dateOut;
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
        return this.name +","+this.dateOut;
    }
}
