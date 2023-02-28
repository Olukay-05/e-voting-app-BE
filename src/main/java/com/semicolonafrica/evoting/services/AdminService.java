package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.dto.request.AddCandidateRequest;
import com.semicolonafrica.evoting.dto.request.AddNonCandidateRequest;
import com.semicolonafrica.evoting.dto.request.AdminLoginRequest;
import com.semicolonafrica.evoting.dto.request.ResultRequest;
import com.semicolonafrica.evoting.dto.response.AddCandidateResponse;
import com.semicolonafrica.evoting.dto.response.AddNonCandidateResponse;
import com.semicolonafrica.evoting.dto.response.AdminLoginResponse;
import com.semicolonafrica.evoting.dto.response.ResultResponse;
import jakarta.mail.MessagingException;

import java.util.List;

public interface AdminService {
    AdminLoginResponse adminLogin(AdminLoginRequest adminLoginRequest);
    AddCandidateResponse addCandidate(AddCandidateRequest addCandidateRequest) throws MessagingException;
    AddNonCandidateResponse addNonCandidate(AddNonCandidateRequest addNonCandidateRequest) throws MessagingException;
    List<Candidate> displayResult();
}
