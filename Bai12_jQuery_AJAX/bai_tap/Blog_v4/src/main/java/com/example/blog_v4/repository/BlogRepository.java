package com.example.blog_v4.repository;

import com.example.blog_v4.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByContentContaining(String name, Pageable pageable);

    @Query(value = "select * from blog join topic on blog.topic_id = topic.id where topic.id = :id", nativeQuery = true)
    Page<Blog> findAllByTopic(@Param("id") Long id, Pageable pageable);

    Blog getBlogById(Long id);
}
