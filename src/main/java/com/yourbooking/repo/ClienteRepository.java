package com.yourbooking.repo;

import com.yourbooking.model.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public List<Cliente> findAll();

    @Query("select c from Cliente c where c.email=:email and c.pwd = :pwd")
    public Cliente findByEmailAndPwd(String email, String pwd);
}

