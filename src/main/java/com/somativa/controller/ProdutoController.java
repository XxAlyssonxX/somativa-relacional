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

import com.somativa.entities.Produto;
import com.somativa.services.ProdutoService;

@RestController
@RequestMapping("/Produto")
@CrossOrigin(origins = "*")
public class ProdutoController {
    private final ProdutoService ProdutoService;

    @Autowired
    public ProdutoController(ProdutoService ProdutoService) {
        this.ProdutoService = ProdutoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscaProdutoControlId(@PathVariable long id) {
        Produto Produto = ProdutoService.buscaProdutoPeloId(id);
        if (Produto != null) {
            return ResponseEntity.ok(Produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscaTodosProdutosControl() {
        List<Produto> Produtos = ProdutoService.buscaTodosProdutos();
        return ResponseEntity.ok(Produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> salvaProdutoControl(@RequestBody Produto Produto) {
        Produto salvaProduto = ProdutoService.salvaProduto(Produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> alteraProdutoControl(@PathVariable Long id, @RequestBody Produto Produto) {
        Produto alteraProduto = ProdutoService.alterarProduto(id, Produto);
        if (alteraProduto != null) {
            return ResponseEntity.ok(Produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id) {
        boolean apagar = ProdutoService.apagarProduto(id);
        if (apagar) {
        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

