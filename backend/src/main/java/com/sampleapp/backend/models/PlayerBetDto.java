package com.sampleapp.backend.models;

import java.util.ArrayList;
import java.util.List;

public class PlayerBetDto {
    public double gain;
    public double stake;
    public int playerId;
    public double coefficient;

    public List<Long> playerBetItems = new ArrayList<>();
}
