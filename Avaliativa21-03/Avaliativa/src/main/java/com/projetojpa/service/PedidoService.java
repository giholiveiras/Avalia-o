package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetojpa.entities.Pedido;
import com.projetojpa.repository.PedidoRepository;

public class PedidoService {

	private final PedidoRepository PedidoRepository;

	@Autowired
	public PedidoService (PedidoRepository PedidoRepository) {
		this.PedidoRepository = PedidoRepository;
	}

	public List<Pedido> getAllPedido () {
		return PedidoRepository.findAll();
	}
	public Pedido getPedidoById (Long id) {
		Optional<Pedido> Pedido = PedidoRepository.findById(id);
		return Pedido.orElse(null);
	}

	public Pedido savePedido(Pedido Pedido) {
		return PedidoRepository.save(Pedido);
	}

	public Pedido putPedido(Long id, Pedido alterarC) {
		Optional <Pedido> existePedido = PedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			alterarC.setId(id);
			return PedidoRepository.save(alterarC);
		}
		return null;
	}

	public boolean deletePedido(Long id) {
		Optional <Pedido> existePedido = PedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			PedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}