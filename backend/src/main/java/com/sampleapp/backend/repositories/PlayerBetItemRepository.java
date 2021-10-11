package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.PlayerBetItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerBetItemRepository extends JpaRepository<PlayerBetItem, Long> {

}
