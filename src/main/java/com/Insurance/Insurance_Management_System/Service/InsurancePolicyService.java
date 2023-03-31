package com.Insurance.Insurance_Management_System.Service;

import com.Insurance.Insurance_Management_System.DTOs.InsurancePolicyDto;
import com.Insurance.Insurance_Management_System.Models.Client;
import com.Insurance.Insurance_Management_System.Models.InsurancePolicy;
import com.Insurance.Insurance_Management_System.Repository.ClientRepository;
import com.Insurance.Insurance_Management_System.Repository.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class InsurancePolicyService {

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    ClientRepository clientRepository;
    public String createPolicy(InsurancePolicyDto insurancePolicyDto){

       Client client = clientRepository.findById(insurancePolicyDto.getClientId()).get();

       InsurancePolicy insurancePolicy = new InsurancePolicy();

       insurancePolicy.setPolicyType(insurancePolicyDto.getPolicyType());
       insurancePolicy.setStartDate(insurancePolicyDto.getStartDate());
       insurancePolicy.setEndDate(insurancePolicyDto.getEndDate());
       insurancePolicy.setPremium(insurancePolicyDto.getPremium());
       insurancePolicy.setCoverageAmount(insurancePolicyDto.getCoverageAmount());

       //set foreign key attr in child class.
       insurancePolicy.setClient(client);

       List<InsurancePolicy> insurancePolicyList = client.getInsurancePolicyList();
       insurancePolicyList.add(insurancePolicy);

       return"InsurancePolicy Created Successfully";
    }

    public List<InsurancePolicy> getAllInsurancePolicy(){
        return insurancePolicyRepository.findAll();
    }

    public InsurancePolicy findInsurancePolicyById(int policyId){
        return insurancePolicyRepository.findById(policyId).get();
    }

    public void deleteInsurancePolicy(int policyId){
        insurancePolicyRepository.deleteById(policyId);
    }

    public String updateInsurancePolicy(int policyId,  double newCoverageAmount, int newPremium){
        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(policyId).get();
        insurancePolicy.setCoverageAmount(newCoverageAmount);
        insurancePolicy.setPremium(newPremium);
        return "Policy update SuccessFully";
    }
}
