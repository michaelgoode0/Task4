package com.company.dao;

import com.company.entities.Room;
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

public class RoomDao implements IRoomDao {
    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/keeper/RoomData.txt";

    public void writeInFile(String data, boolean bool) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, bool))) {
            writer.write(data);
            writer.append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void saveRoom(Room room) {
        writeInFile(room.toString(), true);
    }

    @Override
    public List<Room> getListOfRooms() throws IOException {
        StringBuffer string = new StringBuffer();
        Path path1 = FileSystems.getDefault().getPath(path);
        Files.lines(path1, StandardCharsets.UTF_8).forEach(k -> string.append(k).append(","));
        String k = string.toString();
        List<Room> rooms = new ArrayList<>();
        String[] kek = k.split(",");
        for (int i = 0; i < kek.length / 5; i+=5) {
            Room room = new Room();
            room.setId(kek[i]);
            room.setStars(Integer.parseInt(kek[i+1]));
            room.setStatus(Status.FREE);
            room.setCapacity(Integer.parseInt(kek[i+3]));
            room.setStars(Integer.parseInt(kek[i+4]));
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public void update(Room room) throws Exception {
        List<Room> rooms = getListOfRooms();
        for (var i : rooms) {
            if (i.getId().equals(room.getId())) {
                var index = rooms.indexOf(i);
                rooms.set(index, room);
            } else {
                System.out.println("Client not found");
            }
        }
        StringBuffer update = new StringBuffer();
        for (var i : rooms) {
            update.append(i.toString()).append("\n");
        }
        writeInFile(update.toString(), false);
    }
}
