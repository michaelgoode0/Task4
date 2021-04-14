package com.company.dao;

import com.company.entities.Service;

import java.util.ArrayList;

public interface IServiceDao {

    void saveServices(ArrayList<Service> services);
}
