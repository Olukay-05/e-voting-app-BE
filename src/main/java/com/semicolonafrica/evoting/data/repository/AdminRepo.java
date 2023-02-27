package com.semicolonafrica.evoting.data.repository;

import com.semicolonafrica.evoting.data.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Long> {
}
