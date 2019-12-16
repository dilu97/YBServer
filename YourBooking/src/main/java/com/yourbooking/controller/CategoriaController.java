package com.yourbooking.controller;

import com.yourbooking.model.Categoria;
import com.yourbooking.repo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoriaController {


	@Autowired
    CategoriaRepository repository;

	@GetMapping(value = "/categorie")
	public List<Categoria> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/categorie/{id}")
	public Categoria findById(@PathVariable long id) {
		return repository.findById(id);
	}
/*
	@PostMapping(value = "/customers/create")
	public Customer postCustomer(@RequestBody Customer customer) {

		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));
		return _customer;
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/customers/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		repository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "customers/age/{age}")
	public List<Customer> findByAge(@PathVariable int age) {

		List<Customer> customers = repository.findByAge(age);
		return customers;
	}

	@GetMapping(value = "customers/name/{name}")
	public List<Customer> findByName(@PathVariable String name) {
		return repository.findByName(name);
	}

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
