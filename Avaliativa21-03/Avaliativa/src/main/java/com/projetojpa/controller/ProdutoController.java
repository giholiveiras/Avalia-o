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

import com.projetojpa.entities.Produto;
import com.projetojpa.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {
private final ProdutoService ProdutoService;
	
	@Autowired
	public ProdutoController (ProdutoService ProdutoService) {
		this.ProdutoService = ProdutoService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Produto> getProdutoControlId (@PathVariable Long id) {
		Produto Produto = ProdutoService.getProdutoById(id);
		if (Produto != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Produto>> getAllProdutoControl () {
		List<Produto> Produto = ProdutoService.getAllProduto();
		return ResponseEntity.ok(Produto);
}
	
	
	@PostMapping
	public ResponseEntity <Produto> saveProdutoControl(@RequestBody @Valid Produto Produto) {
		Produto saveProduto = ProdutoService.saveProduto(Produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveProduto);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Produto> putProdutoControl(@PathVariable Long id, @RequestBody @Valid Produto Produto){
		Produto putProduto = ProdutoService.putProduto(id, Produto);
		if (putProduto != null) {
			return ResponseEntity.ok(Produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Produto> deleteProdutoControl (@PathVariable Long id) {
		boolean delete = ProdutoService.deleteProduto(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}