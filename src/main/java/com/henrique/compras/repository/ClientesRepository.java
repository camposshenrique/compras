package com.henrique.compras.repository;

import com.henrique.compras.api.entity.Clientes;
import com.henrique.compras.api.response.ClienteFielDto;
import com.henrique.compras.api.response.ProdutoDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

  @Query(value = "insert into CLIENTES (ID, CPF, NOME)\n"
      + "values\n"
      + "    (1, '05870189179', 'Geraldo Pedro Julio Nascimento'),\n"
      + "    (2, '20623850567', 'Vitória Alícia Mendes'),\n"
      + "    (3, '04372012950', 'Teresinha Daniela Galvão'),\n"
      + "    (4, '85067950013', 'Gabriel Rafael Dias'),\n"
      + "    (5, '03763001590', 'Natália Sandra da Cruz'),\n"
      + "    (6, '1051252612', 'Hadassa Daniela Sales'),\n"
      + "    (7, '74302668512', 'Pietra Antônia Brenda Silva'),\n"
      + "    (8, '29457224965', 'Isis Isis Ramos'),\n"
      + "    (9, '96718391344', 'Ian Joaquim Giovanni Santos');", nativeQuery = true)
  default void insertClients(){}

  @Query(value = "truncate table CLIENTES;", nativeQuery = true)
  default void cleanClients(){}

  @Query("SELECT new com.henrique.compras.api.response.ClienteFielDto(c.nome, c.cpf, COUNT(co.id), SUM(co.quantidade * p.preco)) " +
      "FROM Clientes c JOIN Compras co ON c.id = co.clientes.id " +
      "JOIN Produtos p ON co.produtos.id = p.id " +
      "GROUP BY c.nome, c.cpf " +
      "ORDER BY SUM(co.quantidade * p.preco) DESC, COUNT(co.id) DESC LIMIT 3")
  List<ClienteFielDto> findTop3ClientesFieis();

}
