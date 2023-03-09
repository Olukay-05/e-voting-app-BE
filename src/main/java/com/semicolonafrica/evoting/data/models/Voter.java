package com.semicolonafrica.evoting.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@MappedSuperclass
public class Voter {
    @NotEmpty(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be empty")
    private String fullName;
    @Email
    private String email;
    private String token;
}
