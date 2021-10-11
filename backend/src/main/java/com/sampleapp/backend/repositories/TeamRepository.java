package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.Team;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
