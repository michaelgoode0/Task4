package com.company.dao;

import com.company.entities.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ClientDao implements IClientDao {
    private String path = "C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/keeper/ClientData.txt";

    public void writeInFile(String data, boolean bool) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, bool))) {
            writer.write(data);
            writer.append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveClient(Client client) {
        writeInFile(client.toString(), true);
    }
    @Override
    public List<Client> getListOfClients() throws IOException {
        StringBuffer string = new StringBuffer();
        Path path1 = FileSystems.getDefault().getPath(path);
        Files.lines(path1, StandardCharsets.UTF_8).forEach(k -> string.append(k).append(","));
        String k = string.toString();
        List<Client> clients = new ArrayList<>();
        String[] kek = k.split(",");
        int p = 0;
        for (int i = 0; i < kek.length / 2; i+=2) {
            Client client = new Client();
            client.setName(kek[i + p]);
            client.setDateOut(kek[i + 1 + p]);
            clients.add(client);
            p = 1;
        }
        return clients;
    }

    @Override
    public void update(Client client) throws Exception {
        List<Client> clients = getListOfClients();
        for (var i : clients) {
            if (i.getName().equals(client.getName())) {
                var index = clients.indexOf(i);
                clients.set(index, client);
            } else {
                System.out.println("Client not found");
            }
        }
        StringBuffer update = new StringBuffer();
        for (var i : clients) {
            update.append(i.toString()).append("\n");
        }
        writeInFile(update.toString(), false);
    }
}