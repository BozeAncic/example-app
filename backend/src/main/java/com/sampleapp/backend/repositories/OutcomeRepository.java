package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.Outcome;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeRepository extends JpaRepository<Outcome, Long> {

}
