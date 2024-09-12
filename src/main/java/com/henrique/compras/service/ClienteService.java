package com.henrique.compras.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrique.compras.api.entity.Clientes;
import com.henrique.compras.api.entity.Produtos;
import com.henrique.compras.api.response.ClienteFielDto;
import com.henrique.compras.api.response.ProdutoDto;
import com.henrique.compras.exceptions.EntidadeNaoEncontradaException;
import com.henrique.compras.mapper.ProdutosMapper;
import com.henrique.compras.repository.ClientesRepository;
import com.henrique.compras.repository.ProdutosRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

  private final ClientesRepository clientesRepository;
  private final ProdutosRepository produtosRepository;
  private final ProdutosMapper produtosMapper;

  public List<ClienteFielDto> getTop3ClientesFies(){
   return clientesRepository.findTop3ClientesFieis();
  }

  public ProdutoDto getRecomendacaoVinho(long clientId){
    Produtos produto = produtosRepository.findProdutoRecomendado(clientId).orElseThrow(
        EntidadeNaoEncontradaException::new);
    return produtosMapper.toDto(produto);
  }

}
