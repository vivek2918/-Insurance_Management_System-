package com.Insurance.Insurance_Management_System.Repository;

import com.Insurance.Insurance_Management_System.Models.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim,Integer> {


}
