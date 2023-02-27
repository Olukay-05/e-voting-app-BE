package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.repository.CandidateRepo;
import com.semicolonafrica.evoting.dto.request.VoteRequest;
import com.semicolonafrica.evoting.dto.response.VoteResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

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

    @Override
    public Candidate findCandidate(Long id) {
        return candidateRepo.findById(id).orElseThrow(()-> new RuntimeException("candidate does not exist"));
    }
    @Override
    public VoteResponse vote(VoteRequest voteRequest) {
        Candidate candidate = findCandidate(voteRequest.getCandidateId());

        String token = candidate.getToken();
        VoteResponse voteResponse = new VoteResponse();
        if (Objects.equals(token, voteRequest.getToken())){
            addVote(candidate);
        }
        else throw new RuntimeException("You cannot vote more than once");
        voteResponse.setMessage("Thank you! your vote has been successfully submitted");
        voteResponse.setStatus(HttpStatus.OK);
        return voteResponse;
    }

    private static String hashToken(String token){
        return BCrypt.hashpw(token, BCrypt.gensalt());
    }

    private void addVote(Candidate candidate) {
        long num = candidate.getNoOfVotes() + 1;
        candidate.setNoOfVotes(num);
        String hashToken = hashToken(candidate.getToken());
        candidate.setToken(hashToken);
        addCandidate(candidate);
    }
}
