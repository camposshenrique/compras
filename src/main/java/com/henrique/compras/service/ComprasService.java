package com.henrique.compras.service;

import com.henrique.compras.api.entity.Clientes;
import com.henrique.compras.api.entity.Compras;
import com.henrique.compras.api.response.CompraDto;
import com.henrique.compras.exceptions.EntidadeNaoEncontradaException;
import com.henrique.compras.mapper.ComprasMapper;
import com.henrique.compras.repository.ComprasRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComprasService {

  private final ComprasRepository comprasRepository;
  private final ComprasMapper comprasMapper;

  public List<CompraDto> getAllCompras(){
    return comprasRepository.findAll()
        .stream().map(comprasMapper::toCompraDto)
        .sorted(Comparator.comparing(CompraDto::getTotalCompra))
        .toList();
  }

  public CompraDto getMaiorCompraAno(int compraAno){
    Compras compra = comprasRepository.findMaiorCompraAno(compraAno).orElseThrow(
        EntidadeNaoEncontradaException::new);
    return comprasMapper.toCompraDto(compra);
  }

}
