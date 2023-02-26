package com.semicolonafrica.evoting.controller;


import com.semicolonafrica.evoting.dto.request.AddCandidateRequest;
import com.semicolonafrica.evoting.dto.request.AddVoterRequest;
import com.semicolonafrica.evoting.services.AdminService;
import com.semicolonafrica.evoting.utils.ApiResponse;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("voter-addition")
    public ResponseEntity<ApiResponse> addVoter(@RequestBody AddVoterRequest addVoterRequest,
                                                HttpServletRequest httpServletRequest) throws MessagingException {
         ApiResponse apiResponse= ApiResponse.builder()
                 .statusCode(HttpStatus.CREATED)
                 .data(adminService.addVoter(addVoterRequest))
                 .timeStamp(ZonedDateTime.now())
                 .path(httpServletRequest.getRequestURI())
                 .isSuccessful(true)
                 .build();
         return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
