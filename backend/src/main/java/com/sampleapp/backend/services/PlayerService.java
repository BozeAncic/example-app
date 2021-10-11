package com.sampleapp.backend.services;

import com.sampleapp.backend.models.Player;
import com.sampleapp.backend.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public Player getPlayer(Long id) {
        var player = playerRepository.findById(id).get();
        return player;
    }
}
