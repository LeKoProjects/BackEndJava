package com.LilGlen.Recipes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = Ingrediente.TABLE_NAME)

public class Ingrediente {

   public static final String TABLE_NAME = "ingredients";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String nome;

   private Double quantidade;

   private String unidadeMedida;

   public Ingrediente() {
   }

   public Ingrediente(Long id, String nome, Double quantidade, String unidadeMedida) {
      this.id = id;
      this.nome = nome;
      this.quantidade = quantidade;
      this.unidadeMedida = unidadeMedida;
   }

   public Long getId() {
      return this.id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public Double getQuantidade() {
      return this.quantidade;
   }

   public void setQuantidade(Double quantidade) {
      this.quantidade = quantidade;
   }

   public String getUnidadeMedida() {
      return this.unidadeMedida;
   }

   public void setUnidadeMedida(String unidadeMedida) {
      this.unidadeMedida = unidadeMedida;
   }

   public Ingrediente id(Long id) {
      setId(id);
      return this;
   }

   public Ingrediente nome(String nome) {
      setNome(nome);
      return this;
   }

   public Ingrediente quantidade(Double quantidade) {
      setQuantidade(quantidade);
      return this;
   }

   public Ingrediente unidadeMedida(String unidadeMedida) {
      setUnidadeMedida(unidadeMedida);
      return this;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      Ingrediente other = (Ingrediente) obj;
      return this.id == other.id &&
            Objects.equals(this.nome, other.nome) &&
            Objects.equals(this.quantidade, other.quantidade) &&
            Objects.equals(this.unidadeMedida, other.unidadeMedida);

   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + (int) (this.id ^ (this.id >>> 32));
      return result;
   }

}
