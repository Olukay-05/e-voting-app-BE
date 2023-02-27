package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.NonCandidate;

public interface NonCandidateService extends VoterService{
    void addNonCandidate(NonCandidate nonCandidate);
    boolean voterExists(String email);

}
