package com.yourbooking.controller;

import com.yourbooking.model.Citta;
import com.yourbooking.model.Provincia;
import com.yourbooking.repo.CittaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CittaController {


	@Autowired
	CittaRepository repository;

	/**
	 * @return Elenco città registrated con YB
	 */
	@GetMapping(value = "/citta")
	public List<Citta> findAllCitta() {
		return repository.findAll();
	}

	@GetMapping(value = "citta/sigla/{sigla}")
	public List<Citta> findByName(@PathVariable String sigla) {
		return repository.findAllBySigla(sigla);
	}

	@GetMapping(value = "api/citta")
	public List<Citta> findCittaByProvincia(@RequestParam("provincia") String provincia) {
		return repository.findAllByProvincia(provincia);
	}
}
