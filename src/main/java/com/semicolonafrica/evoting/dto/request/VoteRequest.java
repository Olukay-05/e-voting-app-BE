package com.semicolonafrica.evoting.dto.request;

import com.semicolonafrica.evoting.data.models.Candidate;
import lombok.Data;

@Data
public class VoteRequest {
    private String email;
    private String token;
    private Long candidateId;
}
