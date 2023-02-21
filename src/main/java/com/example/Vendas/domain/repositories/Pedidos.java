package com.example.Vendas.domain.repositories;

import com.example.Vendas.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}
