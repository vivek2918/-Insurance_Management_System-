package com.Insurance.Insurance_Management_System.Controller;


import com.Insurance.Insurance_Management_System.DTOs.ClaimDto;
import com.Insurance.Insurance_Management_System.Models.Claim;
import com.Insurance.Insurance_Management_System.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/claim")
public class ClaimController {

    @Autowired
    ClaimService claimService;

    public ResponseEntity getAllClaim(){
        List<Claim> claimList = claimService.getAllClaim();
        return new ResponseEntity<>(claimList, HttpStatus.ACCEPTED);
    }

    public ResponseEntity findClaimById(int claimId){
        Claim claim = claimService.findClaimById(claimId);
        return new ResponseEntity<>(claim,HttpStatus.FOUND);
    }

    public ResponseEntity createClaim(ClaimDto claimDto){
        String str = claimService.createClaim(claimDto);
        return new ResponseEntity<>(str,HttpStatus.CREATED);
    }

    public ResponseEntity updateClaim(int claimId, String newDescription){
        String str = claimService.updateClaim(claimId,newDescription);
        return new ResponseEntity<>(str,HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteClaim(int claimId){
        claimService.deleteClaim(claimId);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
