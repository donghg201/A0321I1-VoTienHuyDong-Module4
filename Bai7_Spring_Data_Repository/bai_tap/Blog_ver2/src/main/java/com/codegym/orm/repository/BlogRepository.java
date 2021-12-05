package com.codegym.orm.repository;

import com.codegym.orm.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
