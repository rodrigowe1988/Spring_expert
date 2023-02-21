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
import java.util.Optional;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            clientes.save(new Cliente("Rodrigo Weber"));
            clientes.save(new Cliente("Rogerio Weber"));
            clientes.save(new Cliente("Ana Beatriz Josicleide Silva"));

            System.out.println("Listando todos os clientes");
            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            List<Cliente> clienteByNome = clientes.findByNomeLike("eber");
            clienteByNome.forEach(System.out::println);

            Optional<Cliente> clienteQualquer = clientes.findById(1);
            System.out.println(clienteQualquer);

            System.out.println(clientes);

//            List<Cliente> clientesPorNome = clientes.findByNomeOrIdOrderById("%eber%", 3);
//            clientesPorNome.forEach(System.out::println);
//
////
////            todosClientes.forEach(c -> {
////                c.setNome(c.getNome() + " atualizado.");
////                clientes.save(c);
////            });
////            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
////
////            System.out.println("Buscando todos os clientes depois de atualizados ");
////            todosClientes = clientes.findAll();
////            todosClientes.forEach(System.out::println);
////            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
////
////            System.out.println("Buscando cliente por nome");
////
////            clientes.findByNomeLike("Ro").forEach(System.out::println);
////            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
////
////            System.out.println("Deletando todos clientes");
////            clientes.findAll().forEach(c -> {
////                clientes.delete(c);
////            });
////
////            todosClientes = clientes.findAll();
////            if (todosClientes.isEmpty()) {
////                System.out.println("Nenhum cliente encontrado na base de dados...");
////            } else {
////                todosClientes.forEach(System.out::println);
////            }
//            boolean existsByNome = clientes.existsByNome("Rodrigo Weber");
//            System.out.println("Existe um cliente com o nome Rodrigo Weber? " + existsByNome);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
