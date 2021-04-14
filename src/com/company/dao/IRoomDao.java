package com.company.dao;

import com.company.entities.Hotel;
import com.company.entities.Room;

import java.util.ArrayList;

public interface IRoomDao {
    void saveRooms(ArrayList<Room> rooms);
}
