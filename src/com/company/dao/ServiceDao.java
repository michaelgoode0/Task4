package com.company.dao;

import com.company.entities.Client;
import com.company.entities.Room;
import com.company.entities.Service;
import com.company.enums.Status;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao {
    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/keeper/ServiceData.txt";

    public void writeInFile(String data, boolean bool) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, bool))) {
            writer.write(data);
            writer.append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveService(Service service) {
        writeInFile(service.toString(), true);
    }

    @Override
    public List<Service> getListOfServices() throws IOException {
        StringBuffer string = new StringBuffer();
        Path path1 = FileSystems.getDefault().getPath(path);
        Files.lines(path1, StandardCharsets.UTF_8).forEach(k -> string.append(k).append(","));
        String k = string.toString();
        List<Service> services = new ArrayList<>();
        String[] kek = k.split(",");
        for (int i = 0; i < kek.length / 2; i+=2) {
            Service service= new Service();
            service.setName(kek[i]);
            service.setCost(Integer.parseInt(kek[i+1]));
            services.add(service);
        }
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
        writeInFile(update.toString(), false);
    }
}
