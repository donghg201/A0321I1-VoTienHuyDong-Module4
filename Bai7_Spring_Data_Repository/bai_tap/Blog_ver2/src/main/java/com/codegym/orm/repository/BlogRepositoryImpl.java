package com.codegym.orm.repository;

import com.codegym.orm.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Blog getBlogById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b where b.id = :blog_id", Blog.class);
        query.setParameter("blog_id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Blog> getList() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog b", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        if (blog.getId() == null) {
            entityManager.merge(blog);
        } else entityManager.persist(blog);
    }

    @Override
    public void delete(Long id) {
        Blog blog = getBlogById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}
