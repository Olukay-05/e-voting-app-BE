package com.semicolonafrica.evoting.controller;

import com.semicolonafrica.evoting.dto.request.IncreaseCandidateVoteRequest;
import com.semicolonafrica.evoting.dto.request.VoteRequest;
import com.semicolonafrica.evoting.services.CandidateService;
import com.semicolonafrica.evoting.services.NonCandidateService;
import com.semicolonafrica.evoting.utils.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("api/v2/voting/")
@CrossOrigin(origins="*")
public class VoteController {

    @Autowired
    private NonCandidateService nonCandidateService;
    @Autowired
    private CandidateService candidateService;


    @PostMapping("nonCandidate")
    public ResponseEntity<ApiResponse> confirmNonCandidateToken(@RequestBody VoteRequest voteRequest,
                                            HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .data(nonCandidateService.vote(voteRequest))
                .statusCode(HttpStatus.OK)
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("candidate")
    public ResponseEntity<ApiResponse> confirmCandidateToken(@RequestBody VoteRequest voteRequest,
                                            HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .data(candidateService.vote(voteRequest))
                .statusCode(HttpStatus.OK)
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("voting")
    public ResponseEntity<ApiResponse> voting(@RequestBody IncreaseCandidateVoteRequest increaseCandidateVoteRequest,
                                                             HttpServletRequest httpServletRequest){
        ApiResponse response = ApiResponse.builder()
                .data(nonCandidateService.addVote(increaseCandidateVoteRequest))
                .statusCode(HttpStatus.OK)
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
