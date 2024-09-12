package com.henrique.compras.mapper;

import com.henrique.compras.api.entity.Clientes;
import com.henrique.compras.api.entity.Compras;
import com.henrique.compras.api.entity.Produtos;
import com.henrique.compras.api.response.ClienteDto;
import com.henrique.compras.api.response.CompraDto;
import com.henrique.compras.api.response.ProdutoDto;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class ComprasMapper {


  public CompraDto toCompraDto(Compras compras) {

    BigDecimal totalCompra = getTotalCompra(compras);
    ClienteDto clienteDto = toClienteDto(compras.getClientes());
    ProdutoDto produtoDto = toProdutoDto(compras.getProdutos());

    return CompraDto.builder()
        .quantidade(compras.getQuantidade())
        .totalCompra(totalCompra)
        .cliente(clienteDto)
        .produto(produtoDto)
        .build();
  }

  private ProdutoDto toProdutoDto(Produtos produtos) {
    return ProdutoDto.builder()
        .anoCompra(produtos.getAnoCompra())
        .safra(produtos.getSafra())
        .preco(produtos.getPreco())
        .codigo(produtos.getCodigo())
        .tipoVinho(produtos.getTipoVinho())
        .build();
  }


  private BigDecimal getTotalCompra(Compras compras) {
    return compras.getProdutos().getPreco()
        .multiply(BigDecimal.valueOf(compras.getQuantidade()));
  }

  private ClienteDto toClienteDto(Clientes cliente) {
    return ClienteDto.builder()
        .cpf(cliente.getCpf())
        .nome(cliente.getNome())
        .build();
  }

}
