package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.Cliente;
import com.projetojpa.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {
private final ClienteService ClienteService;
	
	@Autowired
	public ClienteController (ClienteService ClienteService) {
		this.ClienteService = ClienteService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Cliente> getClienteControlId (@PathVariable Long id) {
		Cliente Cliente = ClienteService.getClienteById(id);
		if (Cliente != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Cliente>> getAllClienteControl () {
		List<Cliente> Cliente = ClienteService.getAllCliente();
		return ResponseEntity.ok(Cliente);
}
	
	
	@PostMapping
	public ResponseEntity <Cliente> saveClienteControl(@RequestBody @Valid Cliente Cliente) {
		Cliente saveCliente = ClienteService.saveCliente(Cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCliente);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Cliente> putClienteControl(@PathVariable Long id, @RequestBody @Valid Cliente Cliente){
		Cliente putCliente = ClienteService.putCliente(id, Cliente);
		if (putCliente != null) {
			return ResponseEntity.ok(Cliente);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Cliente> deleteClienteControl (@PathVariable Long id) {
		boolean delete = ClienteService.deleteCliente(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}
