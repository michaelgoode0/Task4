package com.company.dao;

import com.company.entities.Hotel;
import com.company.entities.Room;

import java.util.ArrayList;

public interface RoomDao {
    void saveRoom(Room room);

    void updateRoom(Room room);

    ArrayList <Room> getRooms(Hotel hotel);
}
