package com.example.casestudy.model.employee;

import com.example.casestudy.model.contract.Contract;
import com.example.casestudy.model.contract.ContractDetail;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String employee_name;
    private String employee_birthday;
    private String employee_id_card;
    private double employee_salary;
    private String employee_phone;
    private String employee_email;
    private String employee_address;
    private String username;

    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id")
    private Division division;

    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username", referencedColumnName = "username",  insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "employee")
    public List<Contract> contractList;

    public Employee(int employee_id, String employee_name, String employee_birthday, String employee_id_card, double employee_salary, String employee_phone, String employee_email, String employee_address, String username, Division division, EducationDegree educationDegree, Position position, User user, List<Contract> contractList) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.username = username;
        this.division = division;
        this.educationDegree = educationDegree;
        this.position = position;
        this.user = user;
        this.contractList = contractList;
    }

    public Employee() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
