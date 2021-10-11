package com.sampleapp.backend.repositories;

import com.sampleapp.backend.models.BetOffer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BetOfferRepository extends JpaRepository<BetOffer, Long> {
}
