package com.semicolonafrica.evoting.dto.request;

import lombok.Data;

@Data
public class AdminLoginRequest {
    private String name;
    private String password;
}
