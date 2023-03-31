package com.Insurance.Insurance_Management_System.Models;

import com.Insurance.Insurance_Management_System.Enums.ClaimStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "claim_Info")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int claimNumber;

    private String description;

    @CreationTimestamp
    private Date claimDate;

    @Enumerated(value = EnumType.STRING)
    private ClaimStatus claimStatus;

    @ManyToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;

    public Claim() {
    }

    public Claim(int claimNumber, String description, Date claimDate, ClaimStatus claimStatus, InsurancePolicy insurancePolicy) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.insurancePolicy = insurancePolicy;
    }

    public int getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }
}
