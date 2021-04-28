package com.company.dao;

import com.company.entities.Service;
import com.company.fileworker.FileWorker;
import com.company.fileworker.Parser;

import java.io.IOException;
import java.util.List;

public class ServiceDao implements IServiceDao {
    Parser parser;
    FileWorker fileWorker;

    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/recourses/data/ServiceData.csv";

    public ServiceDao(Parser parser, FileWorker fileWorker){
        this.parser=parser;
        this.fileWorker=fileWorker;
    }

    @Override
    public void saveService(Service service) {
        fileWorker.writeInFile(service.toString(), true);
    }

    @Override
    public List<Service> getListOfServices() throws IOException {
        List<Service> services= parser.parseServices(path);
        return services;
    }

    @Override
    public void update(Service service) throws Exception {
        List<Service> services = getListOfServices();
        for (var i :services) {
            if (i.getName().equals(service.getName())) {
                var index = services.indexOf(i);
                services.set(index, service);
            } else {
                System.out.println("Client not found");
            }
        }
        StringBuffer update = new StringBuffer();
        for (var i : services) {
            update.append(i.toString()).append("\n");
        }
        fileWorker.writeInFile(update.toString(), false);
    }

}
