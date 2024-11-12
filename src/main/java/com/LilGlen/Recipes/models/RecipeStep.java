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
@Table(name = RecipeStep.TABLE_NAME)
public class RecipeStep {
    public static final String TABLE_NAME = "recipeStep";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private int stepNumber;

    @Column(name = "instruction", nullable = false)
    @NotNull(groups = CreateRecipe.class)
    @NotEmpty(groups = CreateRecipe.class)
    private String instruction;


    public RecipeStep() {
    }

    public RecipeStep(Long id, Recipe recipe, int stepNumber, String instruction) {
        this.id = id;
        this.recipe = recipe;
        this.stepNumber = stepNumber;
        this.instruction = instruction;
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

    public int getStepNumber() {
        return this.stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getInstruction() {
        return this.instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RecipeStep other = (RecipeStep) obj;
        return this.id == other.id &&
                Objects.equals(this.recipe, other.recipe) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.stepNumber, other.stepNumber) &&
                Objects.equals(this.instruction, other.instruction);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.id ^ (this.id >>> 32));
        return result;
    }
    
}
