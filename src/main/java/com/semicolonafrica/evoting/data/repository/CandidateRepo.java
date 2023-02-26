package com.semicolonafrica.evoting.data.repository;

import com.semicolonafrica.evoting.data.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
}
