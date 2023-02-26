package com.semicolonafrica.evoting.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id
    private String name = "admin";
    private String password = "admin";
}
