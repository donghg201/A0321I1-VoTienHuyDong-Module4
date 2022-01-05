package com.example.casestudy.model.customer;

import com.example.casestudy.model.contract.Contract;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    @NotBlank(message = "Customer name is not blank")
    private String customer_name;
    @NotBlank(message = "Customer birthday is not blank")
    private String customer_birthday;
    @NotBlank(message = "Customer gender is not blank")
    private String customer_gender;
    @NotBlank(message = "Customer id card is not blank")
    private String customer_id_card;
    @Pattern(regexp = "^((0|\\+84){1})+([90|91]{2})+(\\d{7})$", message = "Phone number start with 0 and has 10 number")
    private String customer_phone;
    @Email(message = "Email has to @")
    @NotBlank(message = "Customer email is not blank")
    private String customer_email;
    @NotBlank(message = "Customer address is not blank")
    private String customer_address;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerListcustomer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    public List<Contract> contractList;

    public Customer(int customer_id, String customer_name, String customer_birthday, String customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address, CustomerType customerType, List<Contract> contractList) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
        this.customerType = customerType;
        this.contractList = contractList;
    }

    public Customer() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(String customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
