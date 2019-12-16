package com.yourbooking.controller;

import com.yourbooking.model.Citta;
import com.yourbooking.model.Provincia;
import com.yourbooking.repo.CittaRepository;
import com.yourbooking.repo.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProvinciaController {
	@Autowired
	ProvinciaRepository repository;

	@GetMapping(value = "/province")
	public List<Provincia> findAllProvince() { return repository.findAllByOrderByProvincia(); }

	@GetMapping(value = "api/province")
	public List<Provincia> findAll() {
		return repository.findAll();
	}
}
