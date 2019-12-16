package com.yourbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String descrizione;

    public long getId() { return id; }

    public String getDescrizione() { return descrizione; }

    public void setId(long id) { this.id = id; }

    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
