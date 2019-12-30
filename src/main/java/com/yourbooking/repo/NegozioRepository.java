package com.yourbooking.repo;

import com.yourbooking.model.Categoria;
import com.yourbooking.model.Cliente;
import com.yourbooking.model.Negozio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NegozioRepository extends CrudRepository<Negozio, Long> {
    public List<Negozio> findById(long id);

    public List<Negozio> findAllByCategoria(Categoria categoria);

    @Query("SELECT n FROM Negozio n JOIN Categoria c ON c.id = n.categoria JOIN Citta cc ON cc.id = n.citta WHERE c.id = :categoria AND cc.id = :citta ORDER BY n.valutazione DESC")
    public List<Negozio> findAllByCategoriaAndCitta(long categoria, long citta);

    @Query("select n from Negozio n where n.email=:email and n.pwd = :pwd")
    public Negozio findByEmailAndPwd(String email, String pwd);

    @Query("select n from Negozio n where n.email=:email")
    public Negozio findByEmail(String email);

    @Query(value = "SELECT COUNT(*) FROM cliente_negozio_preferiti c WHERE c.negozio_id = :id GROUP BY c.negozio_id", nativeQuery = true)
    public int getNumeroClientiPreferiti(long id);

    @Query(value = "SELECT COUNT(*) FROM operatore o WHERE o.negozio_id = :id GROUP BY o.negozio_id", nativeQuery = true)
    public int getNumeroOperatori(long id);
}

