package com.semicolonafrica.evoting.controller;


import com.semicolonafrica.evoting.dto.request.AddCandidateRequest;
import com.semicolonafrica.evoting.dto.request.AddNonCandidateRequest;
import com.semicolonafrica.evoting.dto.request.ResultRequest;
import com.semicolonafrica.evoting.services.AdminService;
import com.semicolonafrica.evoting.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("api/v1/admin/")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("candidate-addition")
    public ResponseEntity<ApiResponse> addCandidate(@RequestBody AddCandidateRequest addCandidateRequest,
                                                    HttpServletRequest httpServletRequest) throws MessagingException {
        ApiResponse apiResponse = ApiResponse.builder()
                .statusCode(HttpStatus.CREATED)
                .data(adminService.addCandidate(addCandidateRequest))
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PostMapping("nonCandidate-addition")
    public ResponseEntity<ApiResponse> addVoter(@RequestBody AddNonCandidateRequest addNonCandidateRequest,
                                                HttpServletRequest httpServletRequest) throws MessagingException {
         ApiResponse apiResponse= ApiResponse.builder()
                 .statusCode(HttpStatus.CREATED)
                 .data(adminService.addNonCandidate(addNonCandidateRequest))
                 .timeStamp(ZonedDateTime.now())
                 .path(httpServletRequest.getRequestURI())
                 .isSuccessful(true)
                 .build();
         return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("display-result")
    public ResponseEntity<ApiResponse> result(
                                              HttpServletRequest httpServletRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .statusCode(HttpStatus.OK)
                .data(adminService.displayResult())
                .timeStamp(ZonedDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .isSuccessful(true)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
