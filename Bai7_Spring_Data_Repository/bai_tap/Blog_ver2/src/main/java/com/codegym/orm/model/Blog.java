package com.codegym.orm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String topic;

    private String content;

    public Blog(Long id, String title, String topic, String content) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.content = content;
    }

    public Blog(String title, String topic, String content) {
        this.title = title;
        this.topic = topic;
        this.content = content;
    }

    public Blog() {
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
