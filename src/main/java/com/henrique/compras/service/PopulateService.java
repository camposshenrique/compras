package com.henrique.compras.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.compras.api.entity.Clientes;
import com.henrique.compras.api.entity.Produtos;
import com.henrique.compras.api.response.BuyersDto;
import com.henrique.compras.api.response.ProdutoDto;
import com.henrique.compras.mapper.ClientesMapper;
import com.henrique.compras.mapper.ComprasMapper;
import com.henrique.compras.mapper.ProdutosMapper;
import com.henrique.compras.repository.ClientesRepository;
import com.henrique.compras.repository.ComprasRepository;
import com.henrique.compras.repository.ProdutosRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PopulateService {

  private final ComprasRepository comprasRepository;
  private final ProdutosRepository produtosRepository;
  private final ClientesRepository clientesRepository;
  private final ProdutosMapper produtosMapper;
  private final ClientesMapper clientesMapper;
  private final ComprasMapper comprasMapper;

  public void execute() {

    ObjectMapper objectMapper = new ObjectMapper();

    try {
      List<ProdutoDto> produtosDto = objectMapper.
          readValue(new File("src/main/resources/static/json/wines.json"),
              new TypeReference<List<ProdutoDto>>() {
              }
          );

      List<Produtos> produtos = produtosDto.stream().map(produtosMapper::toEntity)
          .collect(Collectors.toList());

      produtosRepository.saveAll(produtos);

      List<BuyersDto> comprasDto = objectMapper.
          readValue(new File("src/main/resources/static/json/buyers.json"),
              new TypeReference<List<BuyersDto>>() {
              }
          );

      comprasDto.forEach(c -> {
        Clientes cliente = clientesRepository.save(clientesMapper.toEntity(c));
        c.getCompras().forEach(co -> {
          Produtos produto = produtosRepository.findProdutosByCodigo(co.getCodigo());
          comprasRepository.save(comprasMapper.toEntity(co, cliente, produto));
        });
      });

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
