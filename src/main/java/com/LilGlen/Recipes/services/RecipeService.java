package com.LilGlen.Recipes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.models.RecipeCategory;
import com.LilGlen.Recipes.repositories.RecipeRepository;

import jakarta.transaction.Transactional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = this.recipeRepository.findById(id);
        return recipe.orElseThrow(() -> new RuntimeException(
                "Receita não encontrada! Id: " + id + ", Tipo: " + Recipe.class.getName()));
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> searchRecipes(String name, String ingredient, RecipeCategory category) {
        return recipeRepository.findAll().stream()
                .filter(recipe -> name == null || recipe.getName().contains(name))
                .filter(recipe -> ingredient == null || recipe.getIngredients().contains(ingredient))
                .filter(recipe -> category == null || recipe.getCategory().equals(category))
                .toList();
    }

    @Transactional
    public Recipe create(Recipe obj) {
        obj.setId(null);
        obj = this.recipeRepository.save(obj);
        return obj;
    }

    @Transactional
    public Recipe update(Recipe obj) {
        Recipe newObj = findById(obj.getId());
        newObj.setId(null);
        newObj.setName(obj.getName());
        newObj.setAuthor(obj.getAuthor());
        newObj.setIngredients(obj.getIngredients());
        newObj.setInstruction1(obj.getInstruction1());
        newObj.setInstruction2(obj.getInstruction2());
        newObj.setCategory(obj.getCategory());
        return this.recipeRepository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            this.recipeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!");
        }
    }
}
