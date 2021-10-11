package com.sampleapp.backend;

import com.sampleapp.backend.services.GeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationRunner {
    @Autowired
    GeneratorService generatorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        generatorService.generateOffer();

    }
}
