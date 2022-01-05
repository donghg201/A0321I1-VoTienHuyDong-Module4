package com.example.casestudy.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;
    private String role_name;

    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

    public Role(int role_id, String role_name, List<User> userList) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.userList = userList;
    }

    public Role() {
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
