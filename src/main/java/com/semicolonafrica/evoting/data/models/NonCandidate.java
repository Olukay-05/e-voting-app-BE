package com.semicolonafrica.evoting.data.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class NonCandidate extends Voter{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

}
