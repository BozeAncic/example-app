package com.sampleapp.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.sampleapp.backend.models.PlayerBet;
import com.sampleapp.backend.models.PlayerBetDto;
import com.sampleapp.backend.models.View;
import com.sampleapp.backend.services.PlayerBetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerBetController {
    @Autowired
    PlayerBetService playerBetService;

    @PostMapping("/savebet")
    @JsonView(View.BetOffer.class)
    public ResponseEntity<PlayerBet> saveBet(@RequestBody PlayerBetDto data) throws Exception {
        return new ResponseEntity<>(playerBetService.saveBet(data), HttpStatus.OK);
    }
}
