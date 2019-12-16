package com.yourbooking.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String nome;
    String cognome;
    char sesso;
    String email;
    String telefono;
    String pwd;

    @ManyToOne(/*cascade=CascadeType.ALL*/)
    Citta citta;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="cliente_negozioPreferiti", joinColumns=@JoinColumn(name="cliente_id"), inverseJoinColumns=@JoinColumn(name="negozio_id"))
    List<Negozio> preferiti;

    int notifica;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getNotifica() {
        return notifica;
    }

    public void setNotifica(int notifica) {
        this.notifica = notifica;
    }

    public Citta getCitta() {return this.citta;}

    public Cliente clone() {
        Cliente cliente = new Cliente();
        cliente.nome = this.nome;
        cliente.cognome = this.cognome;
        cliente.sesso = this.sesso;
        cliente.email = this.email;
        cliente.telefono = this.telefono;
        cliente.citta = this.citta.clone();
//        cliente.citta = new Citta();
//        cliente.citta.setId(this.citta.getId());
//        cliente.citta.setCap(this.citta.getCap());
//        cliente.citta.setNome(this.citta.getNome());
//        cliente.citta.setProvincia(this.citta.getProvincia());
//        cliente.citta.setRegione(this.citta.getRegione());
//        cliente.citta.setSigla(this.citta.getSigla());

        return cliente;
    }
}
