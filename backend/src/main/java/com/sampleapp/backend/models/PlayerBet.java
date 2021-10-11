package com.sampleapp.backend.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "PlayerBets")
public class PlayerBet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.PlayerBet.class)
    public Long id;

    @Column(name = "stake")
    @JsonView(View.PlayerBet.class)
    public double stake;

    @Column(name = "coefficient")
    @JsonView(View.PlayerBet.class)
    public double coefficient;

    @Column(name = "gain")
    @JsonView(View.PlayerBet.class)
    public double gain;
    @ManyToOne
    public Player player;

    @JsonView(View.PlayerBet.class)
    @OneToMany(mappedBy = "playerBet", cascade = CascadeType.PERSIST)
    public Set<PlayerBetItem> playerBetItems = new HashSet<>();
}
