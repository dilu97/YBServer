package com.yourbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "servizio")
public class Servizio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String descrizione;

    //@OneToMany(mappedBy = "servizio")
    //Set<Negozio> negozi;
}
