package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.ItemPedido;
import com.projetojpa.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	private final ItemPedidoRepository ItemPedidoRepository;

	@Autowired
	public ItemPedidoService (ItemPedidoRepository ItemPedidoRepository) {
		this.ItemPedidoRepository = ItemPedidoRepository;
	}

	public List<ItemPedido> getAllItemPedido () {
		return ItemPedidoRepository.findAll();
	}
	public ItemPedido getItemPedidoById (Long id) {
		Optional<ItemPedido> ItemPedido = ItemPedidoRepository.findById(id);
		return ItemPedido.orElse(null);
	}

	public ItemPedido saveItemPedido(ItemPedido ItemPedido) {
		return ItemPedidoRepository.save(ItemPedido);
	}

	public ItemPedido putItemPedido(Long id, ItemPedido alterarC) {
		Optional <ItemPedido> existeItemPedido = ItemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			alterarC.setId(id);
			return ItemPedidoRepository.save(alterarC);
		}
		return null;
	}

	public boolean deleteItemPedido(Long id) {
		Optional <ItemPedido> existeItemPedido = ItemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			ItemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
