package com.Insurance.Insurance_Management_System.DTOs;

import com.Insurance.Insurance_Management_System.Enums.PolicyType;
import com.Insurance.Insurance_Management_System.Models.Client;


import java.time.LocalDate;

public class InsurancePolicyDto {

    private PolicyType policyType;
    private double coverageAmount;
    private int premium;
    private LocalDate startDate;
    private LocalDate endDate;
    private int clientId;

    public InsurancePolicyDto() {
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
