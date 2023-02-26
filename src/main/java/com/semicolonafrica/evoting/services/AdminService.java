package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.dto.request.AddCandidateRequest;
import com.semicolonafrica.evoting.dto.request.AddVoterRequest;
import com.semicolonafrica.evoting.dto.response.AddCandidateResponse;
import com.semicolonafrica.evoting.dto.response.AddVoterResponse;
import jakarta.mail.MessagingException;

public interface AdminService {
    AddCandidateResponse addCandidate(AddCandidateRequest addCandidateRequest) throws MessagingException;
    AddVoterResponse addVoter(AddVoterRequest addVoterRequest) throws MessagingException;
}
