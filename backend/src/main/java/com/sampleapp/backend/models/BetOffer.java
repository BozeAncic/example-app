package com.sampleapp.backend.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "betoffers")
public class BetOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Base.class)
    public Long id;

    @JsonView(View.Base.class)
    @ManyToOne
    public Team homeTeam;

    @JsonView(View.Base.class)
    @ManyToOne
    public Team awayTeam;

    @JsonView(View.BetOffer.class)
    @OneToMany(mappedBy = "betOffer")
    // @JoinColumn(name = "betoffer_id", nullable = false)
    @OrderBy("outcome ASC")
    public Set<BetOfferItem> betOfferItems;
}
