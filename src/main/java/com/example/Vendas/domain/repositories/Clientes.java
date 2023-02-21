package com.example.Vendas.domain.repositories;

import com.example.Vendas.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from Cliente c where c.nome like %:nome% ", nativeQuery = true)
    List<Cliente> findByNomeLike(@Param("nome") String nome);


//    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    @Query("delete from Cliente c where c.nome like %:nome% ")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);
}
