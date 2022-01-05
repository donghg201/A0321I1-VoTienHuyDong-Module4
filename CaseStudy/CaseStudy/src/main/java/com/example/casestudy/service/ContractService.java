package com.example.casestudy.service;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    public Page<Contract> findAllContract(Pageable pageable);

//    public Page<Customer> findAllByContent(String name, Pageable pageable);

//    public Page<Customer> findAllByTopic(Long id, Pageable pageable);

    Contract getContractById(Integer id);

    public Contract save(Contract contract);
}
