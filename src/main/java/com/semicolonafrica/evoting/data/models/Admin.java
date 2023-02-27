package com.semicolonafrica.evoting.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name = "admin";
    private String password = "admin";

    @OneToMany(mappedBy="admin")
    private List<Candidate> candidateList = new ArrayList<>();

    @OneToMany(mappedBy="admin")
    private List<NonCandidate> nonCandidateList = new ArrayList<>();

}
