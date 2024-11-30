package com.LilGlen.Recipes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.models.RecipeCategory;
import com.LilGlen.Recipes.services.RecipeService;

@RestController
@RequestMapping("/receitas")
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> findById(@PathVariable Long id) {
        try {
            Recipe recipe = recipeService.findById(id);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String query) {
        List<Recipe> recipes = recipeService.searchByQuery(query);
        return ResponseEntity.ok(recipes);
    }
    

    @GetMapping("/searchByCategory")
    public ResponseEntity<List<Recipe>> findRecipesByCategory(@RequestParam RecipeCategory category) {
        List<Recipe> recipes = recipeService.findRecipesByCategory(category);
        return ResponseEntity.ok(recipes);
    }    

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.create(recipe);
        return ResponseEntity.ok(newRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeDetails) {
        Recipe updatedRecipe = recipeService.update(recipeDetails);
        return ResponseEntity.ok(updatedRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        recipeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
