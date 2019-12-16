package com.yourbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Citta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String nome;
    String cap;
    String regione;
    String provincia;
    String sigla;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Citta clone() {
        Citta ret = new Citta();
        ret.setId(this.id);
        ret.setSigla(this.sigla);
        ret.setRegione(this.regione);
        ret.setProvincia(this.provincia);
        ret.setNome(this.nome);
        ret.setCap(this.cap);

        return ret;
    }
}
