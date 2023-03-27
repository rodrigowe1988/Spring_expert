package com.example.Vendas.exception;

public class PedidoNaoEncontradoException extends RuntimeException{

    public PedidoNaoEncontradoException() {
        super("Pedido não encontrado!");
    }
}
