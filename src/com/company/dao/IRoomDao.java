package com.company.dao;

import com.company.entities.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IRoomDao {
    void saveRoom(Room room);

    void update(Room room) throws Exception;

    Room get(int roomId) throws IOException;

    List<Room> getListOfRooms() throws IOException;

}
