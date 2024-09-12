package com.henrique.compras.service;

import com.henrique.compras.repository.ClientesRepository;
import com.henrique.compras.repository.ComprasRepository;
import com.henrique.compras.repository.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PopulateService {

  private final ComprasRepository comprasRepository;
  private final ProdutosRepository produtosRepository;
  private final ClientesRepository clientesRepository;

  public void execute(){
    log.info("Limpando Banco");
    comprasRepository.disableReferentialIntegrity();
    comprasRepository.cleanShopping();
    produtosRepository.cleanProducts();
    clientesRepository.cleanClients();
    comprasRepository.enableReferentialIntegrity();
    log.info("Fim da limpeza ... populando Banco.");
    clientesRepository.insertClients();
    produtosRepository.insertProducts();
    comprasRepository.insertShopping();
    log.info("Banco populado!");
  }

}
