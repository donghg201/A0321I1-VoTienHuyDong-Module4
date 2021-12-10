package com.example.blogmrsnga.repository;

import com.example.blogmrsnga.model.Blog;
import com.example.blogmrsnga.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
        Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findByTitleContaining(String name, Pageable pageable);
}