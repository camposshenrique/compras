package com.henrique.compras.repository;

import com.henrique.compras.api.entity.Produtos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends
    JpaRepository<Produtos, Long> {

  @Query(value = "insert into PRODUTOS (ID, ANO_COMPRA, CODIGO, PRECO, SAFRA, TIPO_VINHO)\n"
      + "values\n"
      + "    (1, 2018, 1, 229.99, '2017', 'Tinto'),\n"
      + "    (2, 2019, 2, 126.50, '2018', 'Branco'),\n"
      + "    (3, 2020, 3, 121.75, '2020', 'Rosé'),\n"
      + "    (4, 2021, 4, 134.25, '2020', 'Espumante'),\n"
      + "    (5, 2022, 5, 128.99, '2021', 'Chardonnay'),\n"
      + "    (6, 2017, 6, 327.50, '2016', 'Tinto'),\n"
      + "    (7, 2018, 7, 125.25, '2017', 'Branco'),\n"
      + "    (8, 2019, 8, 120.99, '2018', 'Rosé'),\n"
      + "    (9, 2020, 9, 135.50, '2019', 'Espumante'),\n"
      + "    (10, 2021, 10, 130.75, '2020', 'Chardonnay'),\n"
      + "    (11, 2018, 11, 128.99, '2017', 'Tinto'),\n"
      + "    (12, 2019, 12, 106.50, '2018', 'Branco'),\n"
      + "    (13, 2020, 13, 121.75, '2019', 'Rosé'),\n"
      + "    (14, 2021, 14, 134.25, '2020', 'Espumante'),\n"
      + "    (15, 2022, 15, 188.99, '2021', 'Chardonnay'),\n"
      + "    (16, 2017, 16, 127.50, '2016', 'Tinto'),\n"
      + "    (17, 2018, 17, 125.25, '2017', 'Branco'),\n"
      + "    (18, 2019, 18, 120.99, '2018', 'Rosé'),\n"
      + "    (19, 2020, 19, 135.50, '2019', 'Espumante'),\n"
      + "    (20, 2021, 20, 130.75, '2020', 'Chardonnay');", nativeQuery = true)
  default void insertProducts(){}

  @Query(value = "truncate table PRODUTOS", nativeQuery = true)
  default void cleanProducts(){}

  @Query(value = "select p.* from PRODUTOS p\n"
      + "join COMPRAS co on p.ID = co.PRODUTOS_ID\n"
      + "join PUBLIC.CLIENTES C on co.CLIENTES_ID = C.ID\n"
      + "where c.ID = :clienteId\n"
      + "order by co.QUANTIDADE desc\n"
      + "limit 1;", nativeQuery = true)
  Optional<Produtos> findProdutoRecomendado(long clienteId);

}
