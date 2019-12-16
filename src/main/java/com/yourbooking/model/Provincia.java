package com.yourbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provincia {
    @Id
    String sigla;

    String provincia;

    public String getSigla() {
        return sigla;
    }

    public String getProvincia() {
        return provincia;
    }
}
