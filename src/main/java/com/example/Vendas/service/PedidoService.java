package com.example.Vendas.service;

import com.example.Vendas.domain.entities.Pedido;
import com.example.Vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );

    Optional<Pedido> obterPedidoCompleto (Integer id);
}