package com.sampleapp.backend.models;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "outcomes")
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Base.class)
    public long id;

    @Column(name = "name")
    @JsonView(View.Base.class)
    public String name;

    @Column(name = "description")
    @JsonView(View.Base.class)
    public String description;

    @JsonIgnore
    @OneToMany(mappedBy = "outcome")
    public Set<BetOfferItem> betOfferItems;
}
