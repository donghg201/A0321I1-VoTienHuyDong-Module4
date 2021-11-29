package com.codegym.orm.repository;

import com.codegym.orm.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}