package com.semicolonafrica.evoting.data.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NonCandidate extends Voter{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
//    @JoinColumn(name="admin_id")
    private Admin admin;
}
