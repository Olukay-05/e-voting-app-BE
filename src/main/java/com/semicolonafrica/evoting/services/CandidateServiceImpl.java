package com.semicolonafrica.evoting.services;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.models.Voter;
import com.semicolonafrica.evoting.data.repository.CandidateRepo;
import com.semicolonafrica.evoting.dto.request.VoteRequest;
import com.semicolonafrica.evoting.dto.response.VoteResponse;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public Candidate findCandidate(String email) {
        return candidateRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("candidate does not exist"));
    }
    @Override
    public VoteResponse vote(VoteRequest voteRequest) {
        Candidate candidate = findCandidate(voteRequest.getEmail());
        VoteResponse voteResponse = new VoteResponse();
        if (Objects.equals(candidate.getToken(), voteRequest.getToken())){
            voteResponse.setId(candidate.getId());
            voteResponse.setMessage("Token confirmed");
            voteResponse.setStatus(HttpStatus.OK);
        }
        else throw new RuntimeException("Invalid token");
        return voteResponse;
    }


    public List<Candidate> findAllCandidates(){
        return candidateRepo.findAll();
    }

    @Override
    public Candidate findCandidateById(Long id) {
            Optional<Candidate> foundCandidate = candidateRepo.findById(id);
            return foundCandidate.get();
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
