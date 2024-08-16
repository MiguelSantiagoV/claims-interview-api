package com.example.interview.service;

import com.example.interview.model.Charge;
import com.example.interview.model.Claim;
import com.example.interview.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public Claim getClaim(UUID id){
        return claimRepository.findById(id).orElse(null);
    }

    public Claim saveClaim(Claim claim){
        Claim savedClaim = claimRepository.save(claim);
        for(Charge charge : claim.getCharges()){
            charge.setClaim(claim);
        }
        return savedClaim;
    }

}
