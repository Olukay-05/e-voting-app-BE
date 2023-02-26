package com.semicolonafrica.evoting.data.repository;

import com.semicolonafrica.evoting.data.models.Candidate;
import com.semicolonafrica.evoting.data.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoterRepo extends JpaRepository<Voter, Long> {
    Optional<Voter> findByEmail(String email);
}
