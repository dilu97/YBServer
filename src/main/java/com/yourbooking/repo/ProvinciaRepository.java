package com.yourbooking.repo;

import com.yourbooking.model.Citta;
import com.yourbooking.model.Negozio;
import com.yourbooking.model.Provincia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProvinciaRepository extends CrudRepository<Provincia, String> {

    public List<Provincia> findProvinciaBySigla(String sigla);

    public List<Provincia> findAllByOrderByProvincia();

    @Query("select distinct c.provincia from Citta c order by c.provincia asc")
    public List<Provincia> findAll();
}
