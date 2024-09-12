package com.henrique.compras.api.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyersDto {

  private String nome;
  private String cpf;
  List<ShoppingDto> compras;

}
