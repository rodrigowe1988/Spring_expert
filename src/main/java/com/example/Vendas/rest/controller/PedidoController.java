package com.example.Vendas.rest.controller;

import com.example.Vendas.domain.entities.ItemPedido;
import com.example.Vendas.domain.entities.Pedido;
import com.example.Vendas.domain.entities.Produto;
import com.example.Vendas.domain.repositories.Pedidos;
import com.example.Vendas.rest.dto.InformacaoItemPedidoDTO;
import com.example.Vendas.rest.dto.InformacoesPedidoDTO;
import com.example.Vendas.rest.dto.PedidoDTO;
import com.example.Vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private Pedidos repository;

    @Autowired
    private PedidoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto) {
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }

    @GetMapping("{id}")
    public InformacoesPedidoDTO getById(@PathVariable Integer id) {
        return service
                .obterPedidoCompleto(id)
                .map(p -> converter(p))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pedido não encontrado!"));
    }

    private InformacoesPedidoDTO converter(Pedido pedido) {
        return InformacoesPedidoDTO
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .items(converter(pedido.getItens()))
                .build();
    }

    private List<InformacaoItemPedidoDTO> converter(List<ItemPedido> itens) {
        if (CollectionUtils.isEmpty(itens)) {
            return Collections.emptyList();
        }

        return itens.stream().map(item -> InformacaoItemPedidoDTO
                .builder().descricaoProduto(item.getProduto().getDescricao())
                .precoUnitario(item.getProduto().getPreco())
                .quantidade(item.getQuantidade())
                .build()
        ).collect(Collectors.toList());
    }

//    IMPLEMENTAÇAO DOS METODOS USANDO PRODUTOCONTROLLER E CLIENTE CONTROLLER COMO BASE
//
//    @GetMapping
//    public ResponseEntity<List<Pedido>> findAll() {
//        List<Pedido> list = repository.findAll();
//
//        return ResponseEntity.ok().body(list);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Pedido save(@RequestBody Pedido pedido) {
//        return repository.save(pedido);
//    }
//
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@PathVariable Integer id, @RequestBody Pedido pedido) {
//        repository
//                .findById(id)
//                .map( p -> {
//                    pedido.setId(p.getId());
//                    repository.save(pedido);
//                    return pedido;
//                }).orElseThrow( () ->
//                        new ResponseStatusException(HttpStatus.NOT_FOUND,
//                                "Pedido não encontrado!"));
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable Integer id) {
//        repository
//                .findById(id)
//                .map( p -> {
//                    repository.delete(p);
//                    return Void.TYPE;
//                }).orElseThrow( () ->
//                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
//    }
//
//    @GetMapping("{id}")
//    public Pedido getById(@PathVariable Integer id) {
//        return repository
//                .findById(id)
//                .orElseThrow( () ->
//                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
//    }
//
//    @GetMapping("/pedidos_busca_especifica")
//    public List<Pedido> find(Pedido filtro) {
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
//
//        Example example = Example.of(filtro, matcher);
//        return repository.findAll(example);
//    }
}
