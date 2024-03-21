package com.somativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somativa.entities.Produto;
import com.somativa.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
    private final ProdutoRepository ProdutoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository ProdutoRepository) {
        this.ProdutoRepository = ProdutoRepository;
    }

    public List<Produto> buscaTodosProdutos() {
        return ProdutoRepository.findAll();
    }

    public Produto buscaProdutoPeloId(Long id) {
        Optional<Produto> Produto = ProdutoRepository.findById(id);
        return Produto.orElse(null);
    }

    public Produto salvaProduto(Produto Produto) {
        return ProdutoRepository.save(Produto);
    }

    public Produto alterarProduto(Long id, Produto alterarProduto) {
        Optional<Produto> existeProduto = ProdutoRepository.findById(id);
        if (existeProduto.isPresent()) {
            alterarProduto.setId(id);
            return ProdutoRepository.save(alterarProduto);
        }
        return null;
    }

    public boolean apagarProduto(Long id) {
        Optional<Produto> existeProduto = ProdutoRepository.findById(id);
        if (existeProduto.isPresent()) {
            ProdutoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}