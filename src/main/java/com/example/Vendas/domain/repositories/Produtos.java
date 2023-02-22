package com.example.Vendas.domain.repositories;

import com.example.Vendas.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
