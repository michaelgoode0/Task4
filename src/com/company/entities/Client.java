package com.company.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Client {

    private String name;
    private Calendar dateOut;

    public Client(String name,Calendar dateOut){
        this.name=name;
        this.dateOut=dateOut;
    }

    public String getName() {
        return name;
    }

    public Calendar getDateOut() {
        return dateOut;
    }

    public String toString(){
        return this.name +"  |"+this.dateOut.getTime();
    }
}
