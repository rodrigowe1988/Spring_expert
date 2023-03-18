package com.example.Vendas;

import com.example.Vendas.domain.entities.Cliente;
import com.example.Vendas.domain.entities.Pedido;
import com.example.Vendas.domain.entities.Produto;
import com.example.Vendas.domain.repositories.Clientes;
import com.example.Vendas.domain.repositories.Pedidos;
import com.example.Vendas.domain.repositories.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes,
                                               @Autowired Pedidos pedidos,
                                               @Autowired Produtos produtos
    ){
        return args -> {

            LocalDate lt = LocalDate.now();

            Cliente c1 = new Cliente(null, "Fulano", "11111111111");
            Cliente c2 =  new Cliente(null, "Ciclano", "11111111112");
            Cliente c3 = new Cliente(null, "Beltrano", "11111111113");
            clientes.save(c1);
            clientes.save(c2);
            clientes.save(c3);

            Pedido ped1 = new Pedido(null, c1, lt, new BigDecimal(4999.9));
            Pedido ped2 =  new Pedido(null, c2, lt, new BigDecimal(9999.9));
            Pedido ped3 = new Pedido(null, c3, lt, new BigDecimal(2999.9));
            pedidos.save(ped1);
            pedidos.save(ped2);
            pedidos.save(ped3);

            Produto prod1 = new Produto(null, "Televisão", new BigDecimal(4999.0));
            Produto prod2 =  new Produto(null, "Notebook", new BigDecimal(9999.9));
            Produto prod3 = new Produto(null, "Lavadora e Secadora", new BigDecimal(2999.9));
            produtos.save(prod1);
            produtos.save(prod2);
            produtos.save(prod3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
