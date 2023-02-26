package com.semicolonafrica.evoting.data.repository;

import com.semicolonafrica.evoting.data.models.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepo extends JpaRepository<Voter, Long> {
}
