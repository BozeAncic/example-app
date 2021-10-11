package com.sampleapp.backend.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.sampleapp.backend.models.BetOffer;
import com.sampleapp.backend.models.View;
import com.sampleapp.backend.services.BetOfferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetOfferController {
    @Autowired
    BetOfferService betOfferService;

    @JsonView(View.BetOffer.class)
    @GetMapping("/betoffers")
    public ResponseEntity<List<BetOffer>> getOutcomes() {

        return new ResponseEntity<>(betOfferService.getBetOffer(), HttpStatus.OK);

    }
}
