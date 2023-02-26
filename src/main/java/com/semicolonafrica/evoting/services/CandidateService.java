package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.models.Voter;

public interface CandidateService {
    void addCandidate(Candidate candidate);
    boolean candidateExists(String email);
}
