package com.example.casestudy.service.impl;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.repository.ContractRepository;
import com.example.casestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAllContract(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract getContractById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }
}
