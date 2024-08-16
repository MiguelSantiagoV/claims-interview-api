package com.example.interview.controller;

import com.example.interview.model.Claim;
import com.example.interview.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable UUID id){
        Claim claim = claimService.getClaim(id);
        if(claim != null){
            return new ResponseEntity<>(claim, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Claim> saveClaim(@RequestBody Claim claim){
        Claim savedClaim = claimService.saveClaim(claim);
        return new ResponseEntity<>(savedClaim, HttpStatus.CREATED);
    }



}
