package com.semicolonafrica.evoting.services;


import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.models.NonCandidate;
import com.semicolonafrica.evoting.data.repository.NonCandidateRepo;
import com.semicolonafrica.evoting.dto.request.VoteRequest;
import com.semicolonafrica.evoting.dto.response.VoteResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class NonCandidateServiceImpl implements NonCandidateService{
    @Autowired
    private NonCandidateRepo nonCandidateRepo;

    @Autowired
    private CandidateService candidateService;


    @Override
    public void addNonCandidate(NonCandidate nonCandidate) {
        nonCandidateRepo.save(nonCandidate);
    }

    @Override
    public boolean voterExists(String email) {
        return nonCandidateRepo.findByEmail(email).isPresent();
    }

    @Override
    public VoteResponse vote(VoteRequest voteRequest) {
        NonCandidate nonCandidate = nonCandidateRepo.findByEmail(voteRequest.getEmail()).orElseThrow(()-> new RuntimeException("nonCandidate does not exist"));
        Candidate candidate = candidateService.findCandidate(voteRequest.getCandidateId());

        String token = nonCandidate.getToken();
        VoteResponse voteResponse = new VoteResponse();
        if (Objects.equals(token, voteRequest.getToken())){
            addVote(nonCandidate, candidate);
        }
        else throw new RuntimeException("You cannot vote more than once");
        voteResponse.setMessage("Thank you! Your vote has been successfully submitted");
        voteResponse.setStatus(HttpStatus.OK);
        return voteResponse;
    }

    private static String hashToken(String token){
        return BCrypt.hashpw(token, BCrypt.gensalt());
    }

    private void addVote(NonCandidate nonCandidate, Candidate candidate) {
        long num = candidate.getNoOfVotes() + 1;
        candidate.setNoOfVotes(num);
        candidateService.addCandidate(candidate);
        String hashToken = hashToken(nonCandidate.getToken());
        nonCandidate.setToken(hashToken);
        addNonCandidate(nonCandidate);
    }
}
