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

import com.projetojpa.entities.Pedido;
import com.projetojpa.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/pedido")
public class PedidoController {
private final PedidoService PedidoService;
	
	@Autowired
	public PedidoController (PedidoService PedidoService) {
		this.PedidoService = PedidoService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Pedido> getPedidoControlId (@PathVariable Long id) {
		Pedido Pedido = PedidoService.getPedidoById(id);
		if (Pedido != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<Pedido>> getAllPedidoControl () {
		List<Pedido> Pedido = PedidoService.getAllPedido();
		return ResponseEntity.ok(Pedido);
}
	
	
	@PostMapping
	public ResponseEntity <Pedido> savePedidoControl(@RequestBody @Valid Pedido Pedido) {
		Pedido savePedido = PedidoService.savePedido(Pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(savePedido);
}
	@PutMapping ("/{id}")
	public ResponseEntity <Pedido> putPedidoControl(@PathVariable Long id, @RequestBody @Valid Pedido Pedido){
		Pedido putPedido = PedidoService.putPedido(id, Pedido);
		if (putPedido != null) {
			return ResponseEntity.ok(Pedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <Pedido> deletePedidoControl (@PathVariable Long id) {
		boolean delete = PedidoService.deletePedido(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}
