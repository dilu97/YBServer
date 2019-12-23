package com.yourbooking.repo;

import com.yourbooking.model.Categoria;
import com.yourbooking.model.Negozio;
import com.yourbooking.model.Prenotazione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long> {
    //public List<Categoria> findAll();

    //@Query("SELECT c from Categoria c WHERE c.id = :id")
    //public Categoria findById(long id);

    @Query("SELECT p FROM Prenotazione p JOIN NegozioServizio s on p.servizio=s.id WHERE s.negozio = :n")
    public List<Prenotazione> findAllPrenotazioniAttiveByNegozio(Negozio n);

    public List<Prenotazione> findAllById(long id);
}

