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

import com.somativa.entities.Fornecedor;
import com.somativa.services.FornecedorService;

@RestController
@RequestMapping("/Fornecedor")
@CrossOrigin(origins = "*")
public class FornecedorController {
    private final FornecedorService FornecedorService;

    @Autowired
    public FornecedorController(FornecedorService FornecedorService) {
        this.FornecedorService = FornecedorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscaFornecedorControlId(@PathVariable long id) {
        Fornecedor Fornecedor = FornecedorService.buscaFornecedorPeloId(id);
        if (Fornecedor != null) {
            return ResponseEntity.ok(Fornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> buscaTodosFornecedorsControl() {
        List<Fornecedor> Fornecedors = FornecedorService.buscaTodosFornecedors();
        return ResponseEntity.ok(Fornecedors);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> salvaFornecedorControl(@RequestBody Fornecedor Fornecedor) {
        Fornecedor salvaFornecedor = FornecedorService.salvaFornecedor(Fornecedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaFornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> alteraFornecedorControl(@PathVariable Long id, @RequestBody Fornecedor Fornecedor) {
        Fornecedor alteraFornecedor = FornecedorService.alterarFornecedor(id, Fornecedor);
        if (alteraFornecedor != null) {
            return ResponseEntity.ok(Fornecedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaFornecedorControl(@PathVariable Long id) {
        boolean apagar = FornecedorService.apagarFornecedor(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
