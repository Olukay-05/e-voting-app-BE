package com.semicolonafrica.evoting.services;


import com.semicolonafrica.evoting.data.models.Voter;
import com.semicolonafrica.evoting.data.repository.VoterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterServiceImpl implements VoterService{
    @Autowired
    private VoterRepo voterRepo;

    @Override
    public void addVoter(Voter voter) {
        voterRepo.save(voter);
    }

    @Override
    public boolean voterExists(String email) {
        return voterRepo.findByEmail(email).isPresent();
    }
}
