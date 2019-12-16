package com.yourbooking.model;

import javax.persistence.*;

@Entity
@Table(name = "operatore")
public class Operatore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    private Negozio negozio;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
