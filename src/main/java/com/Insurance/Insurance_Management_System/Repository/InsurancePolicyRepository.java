package com.Insurance.Insurance_Management_System.Repository;

import com.Insurance.Insurance_Management_System.Models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Integer> {
}
