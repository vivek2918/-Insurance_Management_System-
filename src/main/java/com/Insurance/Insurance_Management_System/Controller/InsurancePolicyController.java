package com.Insurance.Insurance_Management_System.Controller;

import com.Insurance.Insurance_Management_System.DTOs.InsurancePolicyDto;
import com.Insurance.Insurance_Management_System.Models.InsurancePolicy;
import com.Insurance.Insurance_Management_System.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/policy")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    public ResponseEntity getAllInsurancePolicy(){
        List<InsurancePolicy> insurancePolicyList = insurancePolicyService.getAllInsurancePolicy();
        return new ResponseEntity<>(insurancePolicyList, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findInsurancePolicyById(int policyId){
        InsurancePolicy insurancePolicy = insurancePolicyService.findInsurancePolicyById(policyId);
        return new ResponseEntity<>(insurancePolicy,HttpStatus.FOUND);
    }

    public ResponseEntity createPolicy(InsurancePolicyDto insurancePolicyDto){
        String str = insurancePolicyService.createPolicy(insurancePolicyDto);
        return new ResponseEntity<>(str, HttpStatus.CREATED);
    }

    public ResponseEntity updateInsurancePolicy(int policyId,  double newCoverageAmount, int newPremium){
        String str = insurancePolicyService.updateInsurancePolicy(policyId,newCoverageAmount,newPremium);
        return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteInsurancePolicy(int policyId){
        insurancePolicyService.deleteInsurancePolicy(policyId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
