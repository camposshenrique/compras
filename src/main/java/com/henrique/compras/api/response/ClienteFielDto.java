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
public class ClienteFielDto {

  private String nome;
  private String cpf;
  private long totalCompras;
  private BigDecimal totalGasto;

}
