package com.LilGlen.Recipes.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "ingredients", columnDefinition = "LONGTEXT")
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private String ingredients;

    @Column(name = "instruction1", columnDefinition = "LONGTEXT")
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private String instruction1;

    @Column(name = "instruction2",columnDefinition = "LONGTEXT")
    private String instruction2;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private RecipeCategory category;

    public Recipe() {
    }

    public Recipe(Long id, String name, String author, String ingredients, String instruction1, String instruction2,
            RecipeCategory category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.ingredients = ingredients;
        this.instruction1 = instruction1;
        this.instruction2 = instruction2;
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

    public String getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstruction1() {
        return this.instruction1;
    }

    public void setInstruction1(String instruction1) {
        this.instruction1 = instruction1;
    }

    public String getInstruction2() {
        return this.instruction2;
    }

    public void setInstruction2(String instruction2) {
        this.instruction2 = instruction2;
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

    public Recipe ingredients(String ingredients) {
        setIngredients(ingredients);
        return this;
    }

    public Recipe instruction1(String instruction1) {
        setInstruction1(instruction1);
        return this;
    }

    public Recipe instruction2(String instruction2) {
        setInstruction2(instruction2);
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
                Objects.equals(this.instruction1, other.instruction1) &&
                Objects.equals(this.instruction2, other.instruction2) &&

                Objects.equals(this.ingredients, other.ingredients) &&
                Objects.equals(this.author, other.author) &&
                Objects.equals(this.category, other.category);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", author='" + getAuthor() + "'" +
                ", ingredients='" + getIngredients() + "'" +
                ", instruction1='" + getInstruction1() + "'" +
                ", instruction2='" + getInstruction2() + "'" +
                ", category='" + getCategory() + "'" +
                "}";
    }

}