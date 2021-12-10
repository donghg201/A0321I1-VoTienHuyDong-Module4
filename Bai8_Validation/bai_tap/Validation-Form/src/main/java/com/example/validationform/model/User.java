package com.example.validationform.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    private int id = 1;

    @Size(min = 5, max = 45, message = "Toi thieu 5 ky tu va toi da 45 ky tu")
    private String firstName;

    @Size(min = 5, max = 45, message = "Toi thieu 5 ky tu va toi da 45 ky tu")
    private String lastName;

    private String phoneNumber;

    @Range(min = 18, message = "Tuoi phai lon hon hoac bang 18")
    private int age;

    @Email(message = "Dinh dang email phai co @")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
