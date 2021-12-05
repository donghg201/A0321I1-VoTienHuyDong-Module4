package com.codegym.orm.repository;

import com.codegym.orm.model.Blog1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepo extends JpaRepository<Blog1, Long> {

}
