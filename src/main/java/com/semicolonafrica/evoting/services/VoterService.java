package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.dto.request.VoteRequest;
import com.semicolonafrica.evoting.dto.response.VoteResponse;

public interface VoterService {
    VoteResponse vote(VoteRequest voteRequest);
}
