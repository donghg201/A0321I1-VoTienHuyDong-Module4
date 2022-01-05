package com.example.casestudy.model.contract;

import com.example.casestudy.model.service.RentType;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_detail_id;
    private int quantity;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    public ContractDetail(int contract_detail_id, int quantity, AttachService attachService, Contract contract) {
        this.contract_detail_id = contract_detail_id;
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public ContractDetail() {
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
