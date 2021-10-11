package com.sampleapp.backend.services;

import java.util.ArrayList;
import java.util.List;

import com.sampleapp.backend.models.BetOffer;
import com.sampleapp.backend.repositories.BetOfferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetOfferService {
    @Autowired
    BetOfferRepository betOfferRepository;

    public List<BetOffer> getBetOffer() {
        List<BetOffer> betOffers = new ArrayList<BetOffer>();
        betOfferRepository.findAll().forEach(betOffers::add);
        return betOffers;
    }
}
