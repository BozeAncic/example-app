package com.sampleapp.backend.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.PlayerBet.class)
    public long id;

    @JsonView(View.PlayerBet.class)
    @Column(name = "name")
    public String name;

    @JsonView(View.PlayerBet.class)
    @Column(name = "cash")
    public double cashAmount;

    @JsonView(View.PlayerBet.class)
    @OneToMany(mappedBy = "player")
    @OrderBy("id ASC")
    public Set<PlayerBet> playerBets;
}
