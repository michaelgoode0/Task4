package com.company.dao;

import com.company.entities.Client;
import com.company.entities.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RoomDao implements IRoomDao {
    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/keeper/RoomData.txt";

    public void saveRooms(ArrayList<Room> rooms) {
        try (FileWriter out = new FileWriter(path)) {
            for (var item: rooms) {
                out.write(item.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
