package com.somativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somativa.entities.Pedido;
import com.somativa.repositories.PedidoRepository;

@Service
public class PedidoService {
	
    private final PedidoRepository PedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository PedidoRepository) {
        this.PedidoRepository = PedidoRepository;
    }

    public List<Pedido> buscaTodosPedidos() {
        return PedidoRepository.findAll();
    }

    public Pedido buscaPedidoPeloId(Long id) {
        Optional<Pedido> Pedido = PedidoRepository.findById(id);
        return Pedido.orElse(null);
    }

    public Pedido salvaPedido(Pedido Pedido) {
        return PedidoRepository.save(Pedido);
    }

    public Pedido alterarPedido(Long id, Pedido alterarPedido) {
        Optional<Pedido> existePedido = PedidoRepository.findById(id);
        if (existePedido.isPresent()) {
            alterarPedido.setId(id);
            return PedidoRepository.save(alterarPedido);
        }
        return null;
    }

    public boolean apagarPedido(Long id) {
        Optional<Pedido> existePedido = PedidoRepository.findById(id);
        if (existePedido.isPresent()) {
            PedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}