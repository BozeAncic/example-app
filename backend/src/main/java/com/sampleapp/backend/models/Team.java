package com.sampleapp.backend.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Base.class)
    public long id;

    @JsonView(View.Base.class)
    @Column(name = "name")
    public String name;

    @JsonIgnore
    @OneToMany(mappedBy = "homeTeam")
    public Set<BetOffer> homeTeams;

    @JsonIgnore
    @OneToMany(mappedBy = "awayTeam")
    public Set<BetOffer> awayTeams;
}
