package com.Insurance.Insurance_Management_System.Service;

import com.Insurance.Insurance_Management_System.DTOs.ClaimDto;
import com.Insurance.Insurance_Management_System.Models.Claim;
import com.Insurance.Insurance_Management_System.Models.InsurancePolicy;
import com.Insurance.Insurance_Management_System.Repository.ClaimRepository;
import com.Insurance.Insurance_Management_System.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaimService {

    @Autowired
    ClaimRepository claimRepository;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    public String createClaim(ClaimDto claimDto){

        int policyId = claimDto.getPolicyId();
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(policyId).get();

        Claim claim = new Claim();
        claim.setDescription(claimDto.getDescription());
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimStatus(claimDto.getClaimStatus());

        //set foreign attr.
        claim.setInsurancePolicy(insurancePolicy);

        //update the list in parent class
        List<Claim> claimList = insurancePolicy.getClaimList();
        claimList.add(claim);

        return "Claim Created Successfully";
    }

    public List<Claim> getAllClaim(){
        return claimRepository.findAll();
    }

    public Claim findClaimById(int claimId){
        return claimRepository.findById(claimId).get();
    }

    public String updateClaim(int claimId, String newDescription){
        Claim claim = claimRepository.findById(claimId).get();
        claim.setDescription(newDescription);
        return "Claim update Successfully";
    }

    public void deleteClaim(int claimId){
        claimRepository.deleteById(claimId);
    }
}
