package com.company.dao;

import com.company.entities.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IServiceDao {

    void saveService(Service service);

    void update(Service service) throws Exception;

    List<Service> getListOfServices() throws IOException;
}
