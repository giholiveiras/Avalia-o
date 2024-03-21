package com.projetojpa.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projetojpa.entities.Produto;
import com.projetojpa.repository.ProdutoRepository;


@Service
public class ProdutoService {

	private final ProdutoRepository ProdutoRepository;

	@Autowired
	public ProdutoService (ProdutoRepository ProdutoRepository) {
		this.ProdutoRepository = ProdutoRepository;
	}

	public List<Produto> getAllProduto () {
		return ProdutoRepository.findAll();
	}
	public Produto getProdutoById (Long id) {
		Optional<Produto> Produto = ProdutoRepository.findById(id);
		return Produto.orElse(null);
	}

	public Produto saveProduto(Produto Produto) {
		return ProdutoRepository.save(Produto);
	}

	public Produto putProduto(Long id, Produto alterarC) {
		Optional <Produto> existeProduto = ProdutoRepository.findById(id);
		if (existeProduto.isPresent()) {
			alterarC.setId(id);
			return ProdutoRepository.save(alterarC);
		}
		return null;
	}

	public boolean deleteProduto(Long id) {
		Optional <Produto> existeProduto = ProdutoRepository.findById(id);
		if (existeProduto.isPresent()) {
			ProdutoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	}