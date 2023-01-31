package com.example.Vendas;

import com.example.Vendas.domain.entities.Cliente;
import com.example.Vendas.domain.repositories.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Rodrigo Weber");
			clientes.salvar(cliente1);

			Cliente cliente2 = new Cliente();
			cliente2.setNome("Rogério Weber");
			clientes.salvar(cliente2);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
