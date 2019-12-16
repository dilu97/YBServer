package com.yourbooking.repo;

import com.yourbooking.model.Categoria;
import com.yourbooking.model.Citta;
import com.yourbooking.model.Negozio;
import com.yourbooking.model.Provincia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CittaRepository extends CrudRepository<Citta, Long> {
    public List<Citta> findAll();

    public Citta findById(long id);

    public List<Citta> findCittaByNome(String nome);

    public List<Citta> findAllBySigla(String sigla);

    public List<Citta> findAllByProvincia(String provincia);
}

