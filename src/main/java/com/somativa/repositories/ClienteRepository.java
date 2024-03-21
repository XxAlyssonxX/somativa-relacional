package com.somativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somativa.entities.Cliente;

public interface  ClienteRepository extends JpaRepository<Cliente,Long>{

}