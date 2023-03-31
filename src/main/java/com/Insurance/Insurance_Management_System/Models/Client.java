package com.Insurance.Insurance_Management_System.Models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_Info")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String DOB;

    private String address;

    @Column(unique = true)
    private String email;

    private Long mobileNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<InsurancePolicy> insurancePolicyList = new ArrayList<>();

    public Client() {
    }

//    public Client(int id, String name, String DOB, String address, String email, Long mobileNumber, List<InsurancePolicy> insurancePolicyList) {
//        this.id = id;
//        this.name = name;
//        this.DOB = DOB;
//        this.address = address;
//        this.email = email;
//        this.mobileNumber = mobileNumber;
//        this.insurancePolicyList = insurancePolicyList;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<InsurancePolicy> getInsurancePolicyList() {
        return insurancePolicyList;
    }

    public void setInsurancePolicyList(List<InsurancePolicy> insurancePolicyList) {
        this.insurancePolicyList = insurancePolicyList;
    }
}
