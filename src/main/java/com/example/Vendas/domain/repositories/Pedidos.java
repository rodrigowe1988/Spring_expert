package com.example.Vendas.domain.repositories;

import com.example.Vendas.domain.entities.Cliente;
import com.example.Vendas.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}