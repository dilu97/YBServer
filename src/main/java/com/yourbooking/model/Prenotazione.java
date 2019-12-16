package com.yourbooking.model;

import javax.persistence.*;

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String note;

    @ManyToOne
    Operatore operatore;

    @ManyToOne
    Cliente cliente;
    @ManyToOne
    NegozioServizio servizio;
}
