package com.example.Vendas.rest.dto;

/*
{
    "cliente": 1,
    "total": 100,
    "items": [
        {
            "produto": 8,
            "quantidade": 1
        }
    ]
}
*/

import com.example.Vendas.domain.entities.ItemPedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;

}
