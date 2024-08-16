package com.example.interview.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Charge {

    @Id
    private UUID chargeId;

    @Column
    private double amount;

    @Column
    private String procedureCode;

    @ManyToOne
    @JsonBackReference
    private Claim claim;

}
