package com.semicolonafrica.evoting.dto.request;

import com.semicolonafrica.evoting.data.models.Admin;
import lombok.Data;

@Data
public class Request {
    private String fullName;

    private String email;
}
