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

import com.projetojpa.entities.Fornecedor;
import com.projetojpa.service.FornecedorService;

import jakarta.validation.Valid;


@RestController
@RequestMapping ("/fornecedor")
public class FornecedorController {
private final FornecedorService FornecedorService;
	
	@Autowired
	public FornecedorController (FornecedorService FornecedorService) {
		this.FornecedorService = FornecedorService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Fornecedor> getFornecedorControlId (@PathVariable Long id) {
		Fornecedor Fornecedor = FornecedorService.getFornecedorById(id);
		if (Fornecedor != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Fornecedor>> getAllFornecedorControl () {
		List<Fornecedor> Fornecedor = FornecedorService.getAllFornecedor();
		return ResponseEntity.ok(Fornecedor);
}
	
	
	@PostMapping
	public ResponseEntity <Fornecedor> saveFornecedorControl(@RequestBody @Valid Fornecedor Fornecedor) {
		Fornecedor saveFornecedor = FornecedorService.saveFornecedor(Fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveFornecedor);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Fornecedor> putFornecedorControl(@PathVariable Long id, @RequestBody @Valid Fornecedor Fornecedor){
		Fornecedor putFornecedor = FornecedorService.putFornecedor(id, Fornecedor);
		if (putFornecedor != null) {
			return ResponseEntity.ok(Fornecedor);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Fornecedor> deleteFornecedorControl (@PathVariable Long id) {
		boolean delete = FornecedorService.deleteFornecedor(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}
