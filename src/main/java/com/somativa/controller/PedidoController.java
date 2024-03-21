package com.somativa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somativa.entities.Pedido;
import com.somativa.services.PedidoService;

@RestController
@RequestMapping("/Pedido")
@CrossOrigin(origins = "*")
public class PedidoController {
    private final PedidoService PedidoService;

    @Autowired
    public PedidoController(PedidoService PedidoService) {
        this.PedidoService = PedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscaPedidoControlId(@PathVariable long id) {
        Pedido Pedido = PedidoService.buscaPedidoPeloId(id);
        if (Pedido != null) {
            return ResponseEntity.ok(Pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscaTodosPedidosControl() {
        List<Pedido> Pedidos = PedidoService.buscaTodosPedidos();
        return ResponseEntity.ok(Pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> salvaPedidoControl(@RequestBody Pedido Pedido) {
        Pedido salvaPedido = PedidoService.salvaPedido(Pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> alteraPedidoControl(@PathVariable Long id, @RequestBody Pedido Pedido) {
        Pedido alteraPedido = PedidoService.alterarPedido(id, Pedido);
        if (alteraPedido != null) {
            return ResponseEntity.ok(Pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaPedidoControl(@PathVariable Long id) {
        boolean apagar = PedidoService.apagarPedido(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

