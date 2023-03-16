package com.example.Vendas;

import com.example.Vendas.domain.entities.Cliente;
import com.example.Vendas.domain.entities.Pedido;
import com.example.Vendas.domain.repositories.Clientes;
import com.example.Vendas.domain.repositories.Pedidos;
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
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes) {
        return args -> {
            Cliente c1 = new Cliente(null, "Fulano", "11111111111");
            Cliente c2 =  new Cliente(null, "Ciclano", "11111111112");
            Cliente c3 = new Cliente(null, "Beltrano", "11111111113");
            clientes.save(c1);
            clientes.save(c2);
            clientes.save(c3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
