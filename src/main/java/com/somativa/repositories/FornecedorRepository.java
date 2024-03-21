package com.somativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somativa.entities.Fornecedor;

public interface  FornecedorRepository extends JpaRepository<Fornecedor,Long>{

}