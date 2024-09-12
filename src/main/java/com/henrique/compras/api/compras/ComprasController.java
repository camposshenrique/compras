package com.henrique.compras.api.compras;

import com.henrique.compras.api.response.CompraDto;
import com.henrique.compras.service.ComprasService;
import com.henrique.compras.service.PopulateService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ComprasController implements ComprasApi {

  private final PopulateService populateService;
  private final ComprasService comprasService;

  @Override
  public void iniciate() {
    populateService.execute();
  }

  @Override
  public List<CompraDto> getAllCompras() {
    return comprasService.getAllCompras();
  }

  @Override
  public CompraDto getMaiorCompraAno(int anoCompra) {
    return comprasService.getMaiorCompraAno(anoCompra);
  }
}
