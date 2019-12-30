package com.yourbooking.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.yourbooking.model.Citta;
import com.yourbooking.model.Cliente;
import com.yourbooking.model.Prenotazione;
import com.yourbooking.repo.CittaRepository;
import com.yourbooking.repo.ClienteRepository;

import com.yourbooking.repo.PrenotazioneRepository;
import net.minidev.json.JSONObject;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class ClienteController {

	//Non usato
	@PostMapping(value = "api/clienti/create")
	public Cliente postCustomer(@RequestBody Cliente cliente) {
		repository.save(cliente);
		return cliente;
	}

	@Autowired
	ClienteRepository repository;

	@Autowired
	CittaRepository cittaRepository;

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	@Autowired
	private HttpSession httpSession;

	@PostMapping(value = "/api/user/login")
	public JSONObject login(@RequestBody JsonNode credenziali) {
		String email = credenziali.get("email").asText();
		String pwd = credenziali.get("pwd").asText();
		Cliente c = repository.findByEmailAndPwd(email, pwd);
		String res = "nok";
		if(c != null) res = "ok";
		JSONObject ret = new JSONObject();
		ret.put("response", res);

		if(c != null)
			httpSession.setAttribute("id", c.getId());

		return ret;
	}

	//numero : prenotazione attive, passate, prossima prenotazione, negozi prefe
	@PostMapping(value = "/api/user/stats")
	public JSONObject getStats() {
		//long id = Long.valueOf(data.get("id").asText());
		long id = Long.valueOf(httpSession.getAttribute("id").toString());

		LocalDate now = LocalDate.now();
		List<Prenotazione> listPrenotazioni = prenotazioneRepository.findAllByCliente(repository.findById(id));
		int attive = 0, passate = 0;
		Prenotazione next = null;
		for(Prenotazione p : listPrenotazioni){
			if(p.getStatus() != Prenotazione.Status.ABORT && p.getStatus() != Prenotazione.Status.ERROR) {
				if (p.getData().compareTo(now) > 0) {
					if(next == null)next = p;
					attive++;
				}
				else passate++;
			}
		}

		JSONObject ret = new JSONObject();
		ret.put("active", attive);
		ret.put("completed", passate);
		if(next!=null) ret.put("next", next); else ret.put("next", "null");
		ret.put("prefered", repository.getNumeroNegoziPreferiti(id));
		return ret;
	}

	/*
	@PostMapping(value = "api/clienti/create")
	public Cliente registerCliente(@RequestBody JsonNode p) {
		Cliente _cliente = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode rootNode = objectMapper.readTree(p.get("user").asText());
			_cliente = new Cliente();
			_cliente.setNome(rootNode.path("name").asText());
			_cliente.setCognome(rootNode.path("surname").asText());
			_cliente.setEmail(rootNode.path("email").asText());
			_cliente.setPwd(rootNode.path("password").asText());
			_cliente.setSesso(rootNode.path("gender").asText().toUpperCase().charAt(0));
			_cliente.setTelefono(rootNode.path("phone").asText());
			long id = Long.valueOf(rootNode.path("city").asText());
			_cliente.setCitta(cittaRepository.findById(id));
			_cliente.setNotifica(Integer.valueOf(rootNode.path("notification").asText()));
			repository.save(_cliente);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return _cliente;
	}

	 */

}
