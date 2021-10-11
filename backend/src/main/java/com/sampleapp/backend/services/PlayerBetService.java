package com.sampleapp.backend.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.sampleapp.backend.models.Player;
import com.sampleapp.backend.models.PlayerBet;
import com.sampleapp.backend.models.PlayerBetDto;
import com.sampleapp.backend.models.PlayerBetItem;
import com.sampleapp.backend.repositories.BetOfferItemRepository;
import com.sampleapp.backend.repositories.PlayerBetItemRepository;
import com.sampleapp.backend.repositories.PlayerBetRepository;
import com.sampleapp.backend.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerBetService {
    @Autowired
    PlayerBetRepository playerBetRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerBetItemRepository playerBetItemRepository;

    @Autowired
    BetOfferItemRepository betOfferItemRepository;

    @Transactional
    public PlayerBet saveBet(PlayerBetDto data) throws Exception {
        Optional<Player> player = playerRepository.findById((long) data.playerId);

        if (player.isPresent()) {

            var playerToUpdate = player.get();
            if (data.stake > playerToUpdate.cashAmount) {

                throw new Exception("Not enough money");
            }
            playerToUpdate.cashAmount -= data.stake;
            var playerInstance = playerRepository.save(playerToUpdate);

            var playerBet = new PlayerBet();

            playerBet.coefficient = data.coefficient;
            playerBet.gain = data.gain;
            playerBet.player = playerInstance;
            playerBet.stake = data.stake;
            Set<PlayerBetItem> playerBetItems = new HashSet<>();

            var instance = playerBetRepository.save(playerBet);
            for (var i = 0; i < data.playerBetItems.size(); i++) {

                var betOfferItem = betOfferItemRepository.findById(data.playerBetItems.get(i));

                if (betOfferItem.isPresent()) {
                    var item = new PlayerBetItem();
                    item.playerBet = instance;
                    item.betOfferItem = betOfferItem.get();
                    playerBetItems.add(item);
                }

            }

            playerBetItemRepository.saveAll(playerBetItems);
            return instance;
        }

        return null;

    }

}
