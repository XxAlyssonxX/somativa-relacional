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

import com.somativa.entities.Itempedido;
import com.somativa.services.ItempedidoService;

@RestController
@RequestMapping("/Itempedido")
@CrossOrigin(origins = "*")
public class ItempedidoController {
    private final ItempedidoService ItempedidoService;

    @Autowired
    public ItempedidoController(ItempedidoService ItempedidoService) {
        this.ItempedidoService = ItempedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itempedido> buscaItempedidoControlId(@PathVariable long id) {
        Itempedido Itempedido = ItempedidoService.buscaItempedidoPeloId(id);
        if (Itempedido != null) {
            return ResponseEntity.ok(Itempedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Itempedido>> buscaTodosItempedidosControl() {
        List<Itempedido> Itempedidos = ItempedidoService.buscaTodosItempedidos();
        return ResponseEntity.ok(Itempedidos);
    }

    @PostMapping
    public ResponseEntity<Itempedido> salvaItempedidoControl(@RequestBody Itempedido Itempedido) {
        Itempedido salvaItempedido = ItempedidoService.salvaItempedido(Itempedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaItempedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itempedido> alteraItempedidoControl(@PathVariable Long id, @RequestBody Itempedido Itempedido) {
        Itempedido alteraItempedido = ItempedidoService.alterarItempedido(id, Itempedido);
        if (alteraItempedido != null) {
            return ResponseEntity.ok(Itempedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaItempedidoControl(@PathVariable Long id) {
        boolean apagar = ItempedidoService.apagarItempedido(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
