package com.henrique.compras.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produtos {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private int codigo;
  private String tipoVinho;
  private BigDecimal preco;
  private String safra;
  private int anoCompra;
  @OneToMany(mappedBy = "id")
  private List<Compras> compras;

}