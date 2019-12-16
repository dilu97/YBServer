package com.yourbooking.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NegozioServizio {
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "negozio_id")
    Negozio negozio;

    @ManyToOne
    @JoinColumn(name = "servizio_id")
    Servizio servizio;

    double prezzo;

    String descrizione;
}
