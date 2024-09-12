package com.henrique.compras.repository;

import com.henrique.compras.api.entity.Compras;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {

  @Query(value = "insert into PUBLIC.COMPRAS (ID, QUANTIDADE, CLIENTES_ID, PRODUTOS_ID)\n"
      + "values\n"
      + "    (1, 6, 1, 1),\n"
      + "    (2, 4, 1, 15),\n"
      + "    (3, 2, 1, 10),\n"
      + "    (4, 3, 1, 5),\n"
      + "    (5, 5, 1, 2),\n"
      + "    (6, 8, 2, 1),\n"
      + "    (7, 3, 3, 14),\n"
      + "    (8, 3, 3, 20),\n"
      + "    (9, 2, 3, 4),\n"
      + "    (10, 6, 4, 17),\n"
      + "    (11, 4, 4, 19),\n"
      + "    (12, 6, 5, 6),\n"
      + "    (13, 4, 5, 4),\n"
      + "    (14, 3, 6, 19),\n"
      + "    (15, 3, 6, 17),\n"
      + "    (16, 2, 6, 12),\n"
      + "    (17, 3, 7, 3),\n"
      + "    (18, 6, 8, 18),\n"
      + "    (19, 4, 8, 14),\n"
      + "    (20, 6, 9, 15),\n"
      + "    (21, 4, 9, 14),\n"
      + "    (22, 20, 9, 3),\n"
      + "    (23, 13, 9, 17),\n"
      + "    (24, 15, 9, 2);", nativeQuery = true)
  default void insertShopping(){}

  @Query(value = "truncate table COMPRAS", nativeQuery = true)
  default void cleanShopping(){}

  @Query(value = "SET REFERENTIAL_INTEGRITY FALSE;", nativeQuery = true)
  default void disableReferentialIntegrity(){}

  @Query(value = "SET REFERENTIAL_INTEGRITY TRUE;", nativeQuery = true)
  default void enableReferentialIntegrity(){}

  @Query(value = "select\n"
      + "    c.*,\n"
      + "    (c.QUANTIDADE * p.PRECO) as totalCompra\n"
      + "from COMPRAS c\n"
      + "join PUBLIC.PRODUTOS p on p.ID = c.PRODUTOS_ID\n"
      + "where p.ANO_COMPRA = :anoCompra\n"
      + "order by totalCompra DESC\n"
      + "limit 1", nativeQuery = true)
  Optional<Compras> findMaiorCompraAno(int anoCompra);


}
