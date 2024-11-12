package com.LilGlen.Recipes.models;

import jakarta.persistence.Id;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = RecipeCategory.TABLE_NAME)
public class RecipeCategory {
    public static final String TABLE_NAME = "recipeCategory";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public RecipeCategory() {
    }

    public RecipeCategory(Long id, Recipe recipe, Category category) {
        this.id = id;
        this.recipe = recipe;
        this.category = category;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

  @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RecipeCategory other = (RecipeCategory) obj;
        return this.id == other.id &&
                Objects.equals(this.recipe, other.recipe) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.category, other.category);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }
    
}

