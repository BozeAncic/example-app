package com.sampleapp.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.sampleapp.backend.models.Player;
import com.sampleapp.backend.models.View;
import com.sampleapp.backend.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/player/{id}")
    @JsonView(View.PlayerBet.class)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") Long id) {
        return new ResponseEntity<>(playerService.getPlayer(id), HttpStatus.OK);
    }
}
