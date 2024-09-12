package com.henrique.compras.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "compras")
public class Compras {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private int quantidade;
  @ManyToOne(fetch = FetchType.LAZY)
  private Produtos produtos;
  @ManyToOne(fetch = FetchType.LAZY)
  private Clientes clientes;


}