package com.semicolonafrica.evoting.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Candidate extends Voter{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
