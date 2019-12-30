package com.yourbooking.model;

import javax.persistence.*;
import java.time.LocalDate;

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

    LocalDate data;

    @Enumerated(EnumType.STRING)
    Status status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Operatore getOperatore() {
        return operatore;
    }

    public void setOperatore(Operatore operatore) {
        this.operatore = operatore;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NegozioServizio getServizio() {
        return servizio;
    }

    public void setServizio(NegozioServizio servizio) {
        this.servizio = servizio;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        ABORT, ERROR;
    }
}

