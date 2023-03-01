package com.semicolonafrica.evoting.data.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Candidate extends Voter{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private long noOfVotes;
}
