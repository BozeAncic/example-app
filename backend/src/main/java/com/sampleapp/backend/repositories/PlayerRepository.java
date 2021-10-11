package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
