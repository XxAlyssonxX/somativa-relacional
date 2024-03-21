package com.somativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somativa.entities.Fornecedor;
import com.somativa.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	
    private final FornecedorRepository FornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository FornecedorRepository) {
        this.FornecedorRepository = FornecedorRepository;
    }

    public List<Fornecedor> buscaTodosFornecedors() {
        return FornecedorRepository.findAll();
    }

    public Fornecedor buscaFornecedorPeloId(Long id) {
        Optional<Fornecedor> Fornecedor = FornecedorRepository.findById(id);
        return Fornecedor.orElse(null);
    }

    public Fornecedor salvaFornecedor(Fornecedor Fornecedor) {
        return FornecedorRepository.save(Fornecedor);
    }

    public Fornecedor alterarFornecedor(Long id, Fornecedor alterarFornecedor) {
        Optional<Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
        if (existeFornecedor.isPresent()) {
            alterarFornecedor.setId(id);
            return FornecedorRepository.save(alterarFornecedor);
        }
        return null;
    }

    public boolean apagarFornecedor(Long id) {
        Optional<Fornecedor> existeFornecedor = FornecedorRepository.findById(id);
        if (existeFornecedor.isPresent()) {
            FornecedorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
