package com.company.initializer;

import com.company.manager.Worker;

public class Initializer {
    Worker worker=new Worker();
    public Initializer(){
        worker.add("Z1",1000,40,3);
        worker.add("A2",14320,34,3);
        worker.add("43",143220,100,5);
        worker.add("b2",120,10,1);
        worker.add("ok",1320,42,4);

        worker.showRooms();
        worker.sortByCost();
    }

}
