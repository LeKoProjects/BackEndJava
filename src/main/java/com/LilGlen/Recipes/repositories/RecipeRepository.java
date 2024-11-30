package com.LilGlen.Recipes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.models.RecipeCategory;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

     List<Recipe> findByName(String name);
     Optional<Recipe> findByNameAndAuthor(String name, String Author);
     List<Recipe> findByCategory(RecipeCategory category);
     List<Recipe> findByNameContaining(String name);
     List<Recipe> findByIngredientsContaining(String ingredient);
     List<Recipe> findByNameContainingAndIngredientsContaining(String name, String ingredient);
     List<Recipe> findByNameContainingAndCategory(String name, RecipeCategory category);
     List<Recipe> findByIngredientsContainingAndCategory(String ingredient, RecipeCategory category);
     List<Recipe> findByNameContainingAndIngredientsContainingAndCategory(String name, String ingredient, RecipeCategory category);
     List<Recipe> findByNameContainingIgnoreCaseOrIngredientsContainingIgnoreCase(String name, String ingredients);
 }