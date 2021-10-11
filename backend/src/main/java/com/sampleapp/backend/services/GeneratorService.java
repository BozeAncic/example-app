package com.sampleapp.backend.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sampleapp.backend.models.BetOffer;
import com.sampleapp.backend.models.BetOfferItem;
import com.sampleapp.backend.models.Outcome;
import com.sampleapp.backend.models.Team;
import com.sampleapp.backend.repositories.BetOfferItemRepository;
import com.sampleapp.backend.repositories.BetOfferRepository;
import com.sampleapp.backend.repositories.OutcomeRepository;
import com.sampleapp.backend.repositories.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    @Autowired
    OutcomeRepository outcomeRepository;

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    BetOfferRepository betOfferRepository;

    @Autowired
    BetOfferItemRepository betOfferItemRepository;

    public void generateOffer() {
        List<Team> teams = teamRepository.findAll();
        List<Outcome> outcomes = outcomeRepository.findAll();
        List<BetOfferItem> betOfferItems = new ArrayList<>();

        betOfferRepository.saveAll(getRandomElement(teams, teams.size()));

        List<BetOffer> betOffers = betOfferRepository.findAll();
        Random rand = new Random();

        betOffers.forEach((betOffer) -> {
            outcomes.forEach((outcome) -> {
                double rNumber = rand.nextDouble(1.01, 20);
                double coef = Math.round(rNumber * 100);
                BetOfferItem e = new BetOfferItem();
                e.coefficient = coef / 100;
                e.betOffer = betOffer;
                e.outcome = outcome;
                betOfferItems.add(e);
            });
        });

        betOfferItemRepository.saveAll(betOfferItems);

    }

    public List<BetOffer> getRandomElement(List<Team> list, int totalItems) {
        Random rand = new Random();

        // create a temporary list for storing
        // selected element
        List<BetOffer> newList = new ArrayList<>();
        int i = totalItems;
        while (i > 1) {
            int randomHomeIndex = rand.nextInt(list.size());

            Team homeTeam = list.get(randomHomeIndex);
            list.remove(randomHomeIndex);

            int awayTeamIndex = rand.nextInt(list.size());
            Team awayTeam = list.get(awayTeamIndex);
            list.remove(awayTeamIndex);

            BetOffer offer = new BetOffer();
            offer.homeTeam = homeTeam;
            offer.awayTeam = awayTeam;
            newList.add(offer);
            i -= 2;
        }

        return newList;
    }
}
