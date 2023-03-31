package com.Insurance.Insurance_Management_System.Models;

import com.Insurance.Insurance_Management_System.Enums.PolicyType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "policy_info")
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyNumber;

    @Enumerated(value = EnumType.STRING)
    private PolicyType policyType;
    private double coverageAmount;

    private int premium;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne
    @JoinColumn
    private Client client;

    @OneToMany(mappedBy = "insurancePolicy", cascade = CascadeType.ALL)
    private List<Claim> claimList = new ArrayList<>();

    public InsurancePolicy() {
    }

    public InsurancePolicy(int policyNumber, PolicyType policyType, double coverageAmount, int premium, LocalDate startDate, LocalDate endDate, Client client, List<Claim> claimList) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.claimList = claimList;
    }

    public InsurancePolicy(Client client, double amount, int premium) {
         this.client = client;
         this.coverageAmount = amount;
         this.premium = premium;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void setClaimList(List<Claim> claimList) {
        this.claimList = claimList;
    }
}
