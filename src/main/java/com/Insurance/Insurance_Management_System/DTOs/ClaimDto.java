package com.Insurance.Insurance_Management_System.DTOs;

import com.Insurance.Insurance_Management_System.Enums.ClaimStatus;
import java.util.Date;

public class ClaimDto {

    private String description;
    private Date claimDate;
    private ClaimStatus claimStatus;
    private int policyId;

    public ClaimDto() {
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

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }
}
