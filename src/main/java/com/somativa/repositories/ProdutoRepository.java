package com.somativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somativa.entities.Produto;

public interface  ProdutoRepository extends JpaRepository<Produto,Long>{

}