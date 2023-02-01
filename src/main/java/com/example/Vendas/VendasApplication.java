package com.example.Vendas;

import com.example.Vendas.domain.entities.Cliente;
import com.example.Vendas.domain.repositories.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			clientes.salvar(new Cliente("Rodrigo Weber"));
			clientes.salvar(new Cliente("Rogerio Weber"));
			clientes.salvar(new Cliente("Ana Beatriz Josicleide Silva"));

			System.out.println("Listando todos os clientes");
			List<Cliente> todosClientes = clientes.buscarTodosClientes();
			todosClientes.forEach(System.out::println);

//			todosClientes.forEach(c -> {
//				c.setNome(c.getNome() + " atualizado.");
//				clientes.atualizar(c);
//			});
//			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
//
//			System.out.println("Buscando todos os clientes depois de atualizados ");
//			todosClientes = clientes.buscarTodosClientes();
//			todosClientes.forEach(System.out::println);
//
//			System.out.println("Buscando cliente por nome");
//			clientes.buscarPorNome("ger").forEach(System.out::println);
//
//			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
//			System.out.println("Deletando um dos clientes");
//			List<Cliente> clienteParaDeletar = clientes.buscarPorNome("Ana");
//			int idDoClienteParaDeletar = clienteParaDeletar.get(0).getId();
////			String nomeDoClienteParaDeletar = clienteParaDeletar.get(0).getNome();
//
//
//			System.out.println("Clientes após deleção: ");
//			List<Cliente> novoArray = new ArrayList<>();
//			clientes.buscarTodosClientes().forEach(c -> {
//				novoArray.add(c);
//			});
//			//novoArray.remove(idDoClienteParaDeletar);
//
//			//novoArray.remove(idDoClienteParaDeletar);
//			novoArray.forEach(System.out::println);
//			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
//
//			System.out.println("Deletando todos clientes");
//			clientes.buscarTodosClientes().forEach(c -> {
//				clientes.deletar(c);
//			});
//
//			todosClientes = clientes.buscarTodosClientes();
//			if (todosClientes.isEmpty()) {
//				System.out.println("Nenhum cliente encontrado na base de dados...");
//			} else {
//				todosClientes.forEach(System.out::println);
//			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
