package com.yourbooking.model;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.*;

@Entity
@Table(name = "negozio")
public class Negozio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "sito")
    private String sito;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "email")
    private String email;

    @Column(name = "valutazione")
    private double valutazione;

    @OneToMany(mappedBy="negozio")
    private List<Operatore> operatori;

    @OneToMany(mappedBy = "negozio")
    List<NegozioServizio> servizi;

    @ManyToOne
    Citta citta;

    String via;

    @ManyToOne
    Categoria categoria;

    String img;

    String pwd;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSito() {
        return sito;
    }

    public void setSito(String sito) {
        this.sito = sito;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
        this.valutazione = valutazione;
    }

    public List<Operatore> getOperatori() {
        return operatori;
    }

    public void setOperatori(List<Operatore> operatori) {
        this.operatori = operatori;
    }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public List<NegozioServizio> getServizi() {
        return servizi;
    }

    public Citta getCitta() {
        return citta;
    }

    public String getVia() {
        return via;
    }

    public Map<DayOfWeek, List<Intervallo>> getOrario() {
        return orario;
    }

    public void setServizi(List<NegozioServizio> servizi) {
        this.servizi = servizi;
    }

    public void setCitta(Citta citta) {
        this.citta = citta;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setOrario(Map<DayOfWeek, List<Intervallo>> orario) {
        this.orario = orario;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @OneToMany(mappedBy = "negozio", targetEntity = Intervallo.class)
    private Map<DayOfWeek, List<Intervallo>> orario;

    public void addOrarioGiorno(DayOfWeek giorno, TimeZone oraApertura, TimeZone oraChiusura) {
        Intervallo intervallo = new Intervallo();
        intervallo.setOraApertura(oraApertura);
        intervallo.setOraChiusura(oraChiusura);

        orario.get(giorno).add(intervallo);
    }

    @Entity
    @Table(name="intervallo")
    class Intervallo {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column
        private TimeZone oraApertura;

        @Column
        private TimeZone oraChiusura;

        @ManyToOne
        private Negozio negozio;

        public void setOraApertura(TimeZone oraApertura) { this.oraApertura = oraApertura; }

        public void setOraChiusura(TimeZone oraChiusura) { this.oraChiusura = oraChiusura; }
    }

}
