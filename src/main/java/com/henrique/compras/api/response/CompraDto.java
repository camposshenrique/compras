package com.henrique.compras.api.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {

  private int quantidade;
  private BigDecimal totalCompra;
  private ClienteDto cliente;
  private ProdutoDto produto;

}
