package com.example.interview.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Claim {
    @Id
    private UUID claimId;

    @Column
    private Long providerId;

    @Column(length = 10)
    private String providerNPI;

    @Column
    private ArrayList<String> attachments;

    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @Column
    private Date serviceDate;

    @OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Charge> charges;

}
