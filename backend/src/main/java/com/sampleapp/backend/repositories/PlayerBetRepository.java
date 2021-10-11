package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.PlayerBet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerBetRepository extends JpaRepository<PlayerBet, Long> {
}
