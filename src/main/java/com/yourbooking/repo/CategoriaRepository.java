package com.yourbooking.repo;

import com.yourbooking.model.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    public List<Categoria> findAll();

    @Query("SELECT c from Categoria c WHERE c.id = :id")
    public Categoria findById(long id);
}

