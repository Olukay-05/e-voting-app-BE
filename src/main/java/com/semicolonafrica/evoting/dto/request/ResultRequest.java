package com.semicolonafrica.evoting.dto.request;

import com.semicolonafrica.evoting.data.models.Candidate;
import lombok.Data;

import java.util.List;

@Data
public class ResultRequest {
    private List<Candidate> candidateList;
}
