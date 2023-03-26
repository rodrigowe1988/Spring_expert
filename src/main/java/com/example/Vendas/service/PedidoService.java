package com.example.Vendas.service;

import com.example.Vendas.domain.entities.Pedido;
import com.example.Vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar( PedidoDTO dto );
}