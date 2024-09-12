package com.henrique.compras.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

  private String codigo;
  @JsonProperty("tipo_vinho")
  private String tipoVinho;
  private BigDecimal preco;
  private String safra;
  @JsonProperty("ano_compra")
  private int anoCompra;

}
