package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.BetOfferItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BetOfferItemRepository extends JpaRepository<BetOfferItem, Long> {

}
