package com.codegym.orm.form;

public class BlogForm {
    private String blog_id;
    private String title;
    private String topic;
    private String content;
    private String[] level;

    public BlogForm() {
    }

    public BlogForm(String blog_id, String title, String topic, String content) {
        this.blog_id = blog_id;
        this.title = title;
        this.topic = topic;
        this.content = content;
    }

    public String getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(String blog_id) {
        this.blog_id = blog_id;
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

    public String[] getLevel() {
        return level;
    }

    public void setLevel(String[] level) {
        this.level = level;
    }
}
