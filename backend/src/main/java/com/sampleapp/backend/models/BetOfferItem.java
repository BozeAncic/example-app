package com.sampleapp.backend.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "BetOfferItems")
public class BetOfferItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Base.class)
    public long id;

    @JsonView(View.PlayerBet.class)
    @ManyToOne
    @JoinColumn(name = "BetOffer_id", nullable = false)
    public BetOffer betOffer;

    @ManyToOne
    @JoinColumn(name = "Outcome_id")
    @JsonView(View.BetOffer.class)
    public Outcome outcome;

    @Column(name = "coefficient")
    @JsonView(View.Base.class)
    public double coefficient;

    @JsonIgnore
    @OneToMany(mappedBy = "betOfferItem")
    public List<PlayerBetItem> playerBetItems;
}
