package com.henrique.compras.mapper;

import com.henrique.compras.api.entity.Produtos;
import com.henrique.compras.api.response.ProdutoDto;
import org.springframework.stereotype.Component;

@Component
public class ProdutosMapper {

  public ProdutoDto toDto(Produtos produto){
    return ProdutoDto.builder()
        .anoCompra(produto.getAnoCompra())
        .preco(produto.getPreco())
        .safra(produto.getSafra())
        .tipoVinho(produto.getTipoVinho())
        .codigo(produto.getCodigo())
        .build();
  }

  public Produtos toEntity(ProdutoDto produtoDto){
    return Produtos.builder()
        .anoCompra(produtoDto.getAnoCompra())
        .preco(produtoDto.getPreco())
        .safra(produtoDto.getSafra())
        .tipoVinho(produtoDto.getTipoVinho())
        .codigo(produtoDto.getCodigo())
        .build();
  }

}
