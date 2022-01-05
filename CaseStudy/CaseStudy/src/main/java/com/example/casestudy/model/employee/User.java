package com.example.casestudy.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(nullable=false)
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;

    @OneToOne(mappedBy = "user")
    public Employee employee;

    public User(String username, String password, List<Role> roleList, Employee employee) {
        this.username = username;
        this.password = password;
        this.roleList = roleList;
        this.employee = employee;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
