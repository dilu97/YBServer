package com.yourbooking.repo;

import com.yourbooking.model.Cliente;
import com.yourbooking.model.Prenotazione;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public List<Cliente> findAll();

    public Cliente findById(long id);

    @Query("select c from Cliente c where c.email=:email and c.pwd = :pwd")
    public Cliente findByEmailAndPwd(String email, String pwd);

    @Query(value = "SELECT COUNT(*) FROM cliente_negozio_preferiti c WHERE c.cliente_id = :id GROUP BY c.cliente_id", nativeQuery = true)
    public int getNumeroNegoziPreferiti(long id);
}

