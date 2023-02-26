package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.repository.VoterRepo;

public class VoterServiceImpl implements VoterService{

    private final VoterRepo voterRepo;

    public VoterServiceImpl(VoterRepo voterRepo) {
        this.voterRepo = voterRepo;
    }
}
