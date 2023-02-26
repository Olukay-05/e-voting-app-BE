package com.semicolonafrica.evoting.data.repository;

import com.semicolonafrica.evoting.data.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
    Optional<Candidate> findByEmail(String email);
}
