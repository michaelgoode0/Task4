package com.company.dao;

import com.company.entities.Client;
import com.company.entities.Room;
import com.company.enums.Status;
import com.company.fileworker.FileWorker;
import com.company.fileworker.Parser;

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
    Parser parser;
    FileWorker fileWorker;
    private String path ="C:/Users/burts/OneDrive/Документы/GitHub/Task4/src/com/company/recourses/data/Roomdata.csv";

    public  RoomDao(Parser parser, FileWorker fileWorker){
        this.parser=parser;
        this.fileWorker= fileWorker;
    }

    @Override
    public void saveRoom(Room room) {
        fileWorker.writeInFile(room.toString(), true);
    }

    @Override
    public List<Room> getListOfRooms() throws IOException {
        List<Room> rooms = parser.parseRooms(path);
        return rooms;
    }

    @Override
    public void update(Room room) throws Exception {
        List<Room> rooms = getListOfRooms();
        for (var i : rooms) {
            if (i.getId()==(room.getId())) {
                var index = rooms.indexOf(i);
                rooms.set(index, room);
            }
        }
        StringBuffer update = new StringBuffer();
        for (var i : rooms) {
            update.append(i.toString()).append("\n");
        }
        fileWorker.writeInFile(update.toString(), false);
    }

    @Override
    public Room get(int roomId) throws IOException {
        List<Room> rooms= getListOfRooms();
        for(Room i:rooms){
            if(i.getId()==roomId){
                return i;
            }
        }
        System.out.println("Not found");
        return null;
    }
    public void kek() throws IOException {
        List<Room> rooms=getListOfRooms();
        for(var i: rooms){
            System.out.println(i.toString());
        }

    }

}
