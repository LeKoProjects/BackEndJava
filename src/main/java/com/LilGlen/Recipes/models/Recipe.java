package com.LilGlen.Recipes.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Recipe.TABLE_NAME)
public class Recipe {

    public interface CreateRecipe {
    }

    public interface UpdateRecipe {
    }

    public static final String TABLE_NAME = "recipe";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private String name;

    private String author;

    @OneToMany
    @Column(name = "ingredients")
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private List<Ingrediente> ingredientes = new ArrayList<>();

    @Column(name = "steps")
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private String steps;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private RecipeCategory category;

    public Recipe() {
    }

    public Recipe(Long id, String name, String author, List<Ingrediente> ingredientes, String steps,
            RecipeCategory category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.ingredientes = ingredientes;
        this.steps = steps;
        this.category = category;
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

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getSteps() {
        return this.steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public RecipeCategory getCategory() {
        return this.category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }

    public Recipe id(Long id) {
        setId(id);
        return this;
    }

    public Recipe name(String name) {
        setName(name);
        return this;
    }

    public Recipe author(String author) {
        setAuthor(author);
        return this;
    }

    public Recipe ingredientes(List<Ingrediente> ingredientes) {
        setIngredientes(ingredientes);
        return this;
    }

    public Recipe steps(String steps) {
        setSteps(steps);
        return this;
    }

    public Recipe category(RecipeCategory category) {
        setCategory(category);
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
        Recipe other = (Recipe) obj;
        return this.id == other.id &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.author, other.author) &&
                Objects.equals(this.ingredientes(ingredientes), other.ingredientes(ingredientes)) &&
                Objects.equals(this.steps, other.steps) &&
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
