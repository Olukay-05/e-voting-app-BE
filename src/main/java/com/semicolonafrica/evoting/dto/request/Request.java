package com.semicolonafrica.evoting.dto.request;

import com.semicolonafrica.evoting.data.models.Admin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Request {
    private String fullName;
    private String email;
}
