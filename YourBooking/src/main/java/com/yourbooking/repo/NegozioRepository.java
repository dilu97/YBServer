package com.yourbooking.repo;

import com.yourbooking.model.Categoria;
import com.yourbooking.model.Negozio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NegozioRepository extends CrudRepository<Negozio, Long> {
    public List<Negozio> findById(long id);

    public List<Negozio> findAllByCategoria(Categoria categoria);

    @Query("SELECT n FROM Negozio n JOIN Categoria c ON c.id = n.categoria JOIN Citta cc ON cc.id = n.citta WHERE c.id = :categoria AND cc.id = :citta ORDER BY n.valutazione DESC")
    public List<Negozio> findAllByCategoriaAndCitta(long categoria, long citta);

}

