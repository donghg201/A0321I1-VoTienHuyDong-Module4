package com.example.casestudy.service;

import com.example.casestudy.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    public Page<Service> findAllService(Pageable pageable);

//    public Page<Customer> findAllByContent(String name, Pageable pageable);

//    public Page<Customer> findAllByTopic(Long id, Pageable pageable);

    Service getServiceById(Integer id);

    public Service save(Service service);
}
