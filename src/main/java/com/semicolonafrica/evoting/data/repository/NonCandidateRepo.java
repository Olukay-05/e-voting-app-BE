package com.semicolonafrica.evoting.data.repository;

import com.semicolonafrica.evoting.data.models.NonCandidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NonCandidateRepo extends JpaRepository<NonCandidate, Long> {
    Optional<NonCandidate> findByEmail(String email);
}
