package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Fornecedor;
import com.projetojpa.repository.FornecedorRepository;


@Service
public class FornecedorService {
	private final FornecedorRepository FornecedorRepository;

	@Autowired
	public FornecedorService (FornecedorRepository FornecedorRepository) {
		this.FornecedorRepository = FornecedorRepository;
	}

	public List<Fornecedor> getAllFornecedor () {
		return FornecedorRepository.findAll();
	}
	public Fornecedor getFornecedorById (Long id) {
		Optional<Fornecedor> Fornecedor = FornecedorRepository.findById(id);
		return Fornecedor.orElse(null);
	}

	public Fornecedor saveFornecedor(Fornecedor Fornecedor) {
		return FornecedorRepository.save(Fornecedor);
	}

	public Fornecedor putFornecedor(Long id, Fornecedor alterarC) {
		Optional <Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			alterarC.setId(id);
			return FornecedorRepository.save(alterarC);
		}
		return null;
	}

	public boolean deleteFornecedor(Long id) {
		Optional <Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			FornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
	}
