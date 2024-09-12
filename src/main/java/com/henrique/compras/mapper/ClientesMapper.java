package com.henrique.compras.mapper;

import com.henrique.compras.api.entity.Clientes;
import com.henrique.compras.api.response.BuyersDto;
import com.henrique.compras.api.response.ClienteFielDto;
import org.springframework.stereotype.Component;

@Component
public class ClientesMapper {

  public Clientes toEntity(BuyersDto buyer){

    return Clientes.builder()
        .nome(buyer.getNome())
        .cpf(buyer.getCpf())
        .build();

  }

}
