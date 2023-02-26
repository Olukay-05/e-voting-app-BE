package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.models.Voter;

public interface VoterService {
    void addVoter(Voter voter);
    boolean voterExists(String email);

}
