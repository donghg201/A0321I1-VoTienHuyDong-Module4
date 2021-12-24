package com.example.blog_v4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne(targetEntity = Topic.class)
    @JsonBackReference
    private Topic topic;

    public Blog() {
    }

    public Blog(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Blog(Long id, String title, String content, Topic topic) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic(){
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
