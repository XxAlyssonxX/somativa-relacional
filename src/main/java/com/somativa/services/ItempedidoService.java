package com.somativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somativa.entities.Itempedido;
import com.somativa.repositories.ItempedidoRepository;

@Service
public class ItempedidoService {
	
    private final ItempedidoRepository ItempedidoRepository;

    @Autowired
    public ItempedidoService(ItempedidoRepository ItempedidoRepository) {
        this.ItempedidoRepository = ItempedidoRepository;
    }

    public List<Itempedido> buscaTodosItempedidos() {
        return ItempedidoRepository.findAll();
    }

    public Itempedido buscaItempedidoPeloId(Long id) {
        Optional<Itempedido> Itempedido = ItempedidoRepository.findById(id);
        return Itempedido.orElse(null);
    }

    public Itempedido salvaItempedido(Itempedido Itempedido) {
        return ItempedidoRepository.save(Itempedido);
    }

    public Itempedido alterarItempedido(Long id, Itempedido alterarItempedido) {
        Optional<Itempedido> existeItempedido = ItempedidoRepository.findById(id);
        if (existeItempedido.isPresent()) {
            alterarItempedido.setId(id);
            return ItempedidoRepository.save(alterarItempedido);
        }
        return null;
    }

    public boolean apagarItempedido(Long id) {
        Optional<Itempedido> existeItempedido = ItempedidoRepository.findById(id);
        if (existeItempedido.isPresent()) {
            ItempedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
  }
