package com.example.casestudy.repository;

import com.example.casestudy.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
