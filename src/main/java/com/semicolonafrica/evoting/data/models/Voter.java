package com.semicolonafrica.evoting.data.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class Voter {
    private String fullName;
    private String email;
    private String token;
}
