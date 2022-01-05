package com.example.casestudy.model.contract;

import com.example.casestudy.model.customer.Customer;
import com.example.casestudy.model.employee.Division;
import com.example.casestudy.model.employee.Employee;
import com.example.casestudy.model.service.Service;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;
    private String contract_start_date;
    private String contract_end_date;
    private double contract_deposit;
    private double contract_total_money;

    @OneToMany(mappedBy = "contract")
    public List<ContractDetail> contractDetailList;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id")
    private Service service;

    public Contract(int contract_id, String contract_start_date, String contract_end_date, double contract_deposit, double contract_total_money, List<ContractDetail> contractDetailList, Customer customer, Employee employee, Service service) {
        this.contract_id = contract_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.contractDetailList = contractDetailList;
        this.customer = customer;
        this.employee = employee;
        this.service = service;
    }

    public Contract() {
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
