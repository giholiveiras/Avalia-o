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

import com.projetojpa.entities.ItemPedido;
import com.projetojpa.service.ItemPedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/item_pedido")
public class ItemPedidoController {
private final ItemPedidoService ItemPedidoService;
	
	@Autowired
	public ItemPedidoController (ItemPedidoService ItemPedidoService) {
		this.ItemPedidoService = ItemPedidoService;
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ItemPedido> getItemPedidoControlId (@PathVariable Long id) {
		ItemPedido ItemPedido = ItemPedidoService.getItemPedidoById(id);
		if (ItemPedido != null) {
			
		}
		return ResponseEntity.notFound().build();
	}

	
	
	@GetMapping ()
	public ResponseEntity <List<ItemPedido>> getAllItemPedidoControl () {
		List<ItemPedido> ItemPedido = ItemPedidoService.getAllItemPedido();
		return ResponseEntity.ok(ItemPedido);
}
	
	
	@PostMapping
	public ResponseEntity <ItemPedido> saveItemPedidoControl(@RequestBody @Valid ItemPedido ItemPedido) {
		ItemPedido saveItemPedido = ItemPedidoService.saveItemPedido(ItemPedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveItemPedido);
}
	@PutMapping ("/{id}")
	public ResponseEntity <ItemPedido> putItemPedidoControl(@PathVariable Long id, @RequestBody @Valid ItemPedido ItemPedido){
		ItemPedido putItemPedido = ItemPedidoService.putItemPedido(id, ItemPedido);
		if (putItemPedido != null) {
			return ResponseEntity.ok(ItemPedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping ("/{id}")
	public ResponseEntity <ItemPedido> deleteItemPedidoControl (@PathVariable Long id) {
		boolean delete = ItemPedidoService.deleteItemPedido(id);
		if (delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();

		
}
}
}