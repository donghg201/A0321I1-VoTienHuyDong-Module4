package com.example.blog_v4.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;

    @OneToMany(mappedBy = "topic")
    @JsonManagedReference
    private List<Blog> blogList;

    public Topic() {
    }

    public Topic(Long id, String topic, List<Blog> blogList) {
        this.id = id;
        this.topic = topic;
        this.blogList = blogList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }


}
