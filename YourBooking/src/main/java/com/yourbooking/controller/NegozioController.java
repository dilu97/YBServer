package com.yourbooking.controller;

import com.yourbooking.model.Categoria;
import com.yourbooking.model.Negozio;
import com.yourbooking.repo.CategoriaRepository;
import com.yourbooking.repo.NegozioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/api")
public class 	NegozioController {

	@Autowired
	NegozioRepository repository;

	@Autowired
	CategoriaRepository categoriaRepository;


	@GetMapping("/negozi")
	public List<Negozio> getAllNegozi() {
		List<Negozio> negozi = new ArrayList<>();

		repository.findAll().forEach(negozi::add);

		return negozi;
	}

	//https://www.baeldung.com/spring-request-param

	@GetMapping(value = "negozi/{id}")
	public List<Negozio> findById(@PathVariable long id) {
		return repository.findById(id);
	}

	@GetMapping(value = "negozi/categoria")
	public List<Negozio> findByCategoria(@RequestParam("categoria") long categoria) {
		Categoria c = categoriaRepository.findById(categoria);
		return repository.findAllByCategoria(c);
	}

	@GetMapping(value = "negozi/citta")
	public List<Negozio> findAllByCategoriaAndCitta(@RequestParam("categoria") long categoria, @RequestParam("citta") long citta) {
		return repository.findAllByCategoriaAndCitta(categoria, citta);
	}

	@PostMapping(value = "/negozi/create")
	public Negozio postNegozio(@RequestBody Negozio negozio) {
		Negozio _negozio = new Negozio();
		_negozio.setDescrizione(negozio.getDescrizione());
		_negozio.setEmail(negozio.getEmail());
		_negozio.setFacebook(negozio.getFacebook());
		_negozio.setInstagram(negozio.getInstagram());
		_negozio.setNome(negozio.getNome());
		_negozio.setOperatori(negozio.getOperatori());
		_negozio.setSito(negozio.getSito());
		_negozio.setTelefono(negozio.getTelefono());

		return repository.save(_negozio);
	}


	/*
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Customer> customerData = repository.findById(id);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	 */
}
