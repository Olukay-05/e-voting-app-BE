package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.models.Voter;
import com.semicolonafrica.evoting.data.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService{
    @Autowired
    private CandidateRepo candidateRepo;
    @Override
    public void addCandidate(Candidate candidate) {
        candidateRepo.save(candidate);
    }

    @Override
    public boolean candidateExists(String email) {
        return candidateRepo.findByEmail(email).isPresent();
    }
}
