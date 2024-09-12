package com.henrique.compras.api.clientes;

import com.henrique.compras.api.response.ClienteFielDto;
import com.henrique.compras.api.response.ProdutoDto;
import com.henrique.compras.service.ClienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientesController implements ClientesApi{

  private final ClienteService clienteService;

  @Override
  public List<ClienteFielDto> getClientesFieis() {
    return clienteService.getTop3ClientesFies();
  }

  @Override
  public ProdutoDto getRecomendacaoVinho(String clienteCpf) {
    return clienteService.getRecomendacaoVinho(clienteCpf);
  }
}
