package com.somativa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.somativa.entities.Pedido;

public interface  PedidoRepository extends JpaRepository<Pedido,Long>{

}
