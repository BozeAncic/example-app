package com.sampleapp.backend.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.sampleapp.backend.models.Outcome;
import com.sampleapp.backend.models.View;
import com.sampleapp.backend.services.OutcomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutcomeController {
    @Autowired
    OutcomeService outcomeService;

    @JsonView(View.Base.class)
    @GetMapping("/outcomes")
    public ResponseEntity<List<Outcome>> getOutcomes() {

        return new ResponseEntity<>(outcomeService.getOutcomes(), HttpStatus.OK);

    }
}
