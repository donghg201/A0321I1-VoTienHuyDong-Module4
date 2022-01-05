package com.example.casestudy.service.impl;

import com.example.casestudy.model.service.Service;
import com.example.casestudy.repository.ServiceRepository;
import com.example.casestudy.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<Service> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Service getServiceById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public Service save(Service service) {
        return serviceRepository.save(service);
    }
}
