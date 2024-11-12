package com.LilGlen.Recipes.models;

import java.util.Objects;

import com.LilGlen.Recipes.models.Recipe.CreateRecipe;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = RecipeIngredient.TABLE_NAME)
public class RecipeIngredient {
    public static final String TABLE_NAME = "recipeIngredient";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")

    private Ingredient ingredient;

    @Column(name = "name")
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private String name;

    private String quantity;

    private String unit;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Long id, Recipe recipe, Ingredient ingredient, String quantity, String unit, String name) {
        this.id = id;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RecipeIngredient other = (RecipeIngredient) obj;
        return this.id == other.id &&
                Objects.equals(this.recipe, other.recipe) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.ingredient, other.ingredient) &&
                Objects.equals(this.quantity, other.quantity) &&
                Objects.equals(this.unit, other.unit) &&
                Objects.equals(this.name, other.name);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }

}
