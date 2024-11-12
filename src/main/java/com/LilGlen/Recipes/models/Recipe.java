package com.LilGlen.Recipes.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    private String description;

    private int prepTime;

    private int cookTime;

    private int totalTime;

    private int servings;

    private String author;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeStep> steps;

    @OneToMany(mappedBy = "recipe")
    private List<RecipeIngredient> ingredients;

    public Recipe() {
    }

    public Recipe(Long id, String name, String description, int prepTime, int cookTime, int totalTime, int servings,
            String author, List<RecipeStep> steps, List<RecipeIngredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.servings = servings;
        this.author = author;
        this.steps = steps;
        this.ingredients = ingredients;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrepTime() {
        return this.prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getServings() {
        return this.servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<RecipeStep> getSteps() {
        return this.steps;
    }

    public void setSteps(List<RecipeStep> steps) {
        this.steps = steps;
    }

    public List<RecipeIngredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
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
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.prepTime, other.prepTime) &&
                Objects.equals(this.cookTime, other.cookTime) &&
                Objects.equals(this.totalTime, other.totalTime) &&
                Objects.equals(this.servings, other.servings) &&
                Objects.equals(this.author, other.author) &&
                Objects.equals(this.steps, other.steps) &&
                Objects.equals(this.ingredients, other.ingredients);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }

}

