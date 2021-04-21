package com.company.administrator;

import com.company.dao.IServiceDao;
import com.company.entities.Service;

public class ServiceService {
    private IServiceDao serviceDao;

    public void setServiceDao(IServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    public void addService(Service service){
        serviceDao.saveService(service);
    }
}
