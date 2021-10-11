package com.sampleapp.backend.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "PlayerBetItems")
public class PlayerBetItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.PlayerBet.class)
    public Long id;

    @ManyToOne
    // @MapsId("betOfferItemId")
    // @JoinColumn(name = "BetOfferItem_id")
    @JsonView(View.PlayerBet.class)
    public BetOfferItem betOfferItem;

    @JsonIgnore
    @ManyToOne
    // @MapsId("PlayerBetId")
    // @JoinColumn(name = "PlayerBet_id")
    public PlayerBet playerBet;
}
