package com.sampleapp.backend.services;

import java.util.ArrayList;
import java.util.List;

import com.sampleapp.backend.models.Outcome;
import com.sampleapp.backend.repositories.OutcomeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutcomeService {

    @Autowired
    OutcomeRepository outcomeRepository;

    public List<Outcome> getOutcomes() {
        List<Outcome> outcomes = new ArrayList<Outcome>();
        outcomeRepository.findAll().forEach(outcomes::add);
        return outcomes;
    }
}
