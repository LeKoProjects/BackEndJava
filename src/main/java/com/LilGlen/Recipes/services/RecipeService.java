package com.LilGlen.Recipes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LilGlen.Recipes.models.Recipe;
import com.LilGlen.Recipes.repositories.RecipeRepository;

import jakarta.transaction.Transactional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe findById(Long id) {
        Optional<Recipe> recipe = this.recipeRepository.findById(id);
        return recipe.orElseThrow(() -> new RuntimeException(
                "Usuário não encontrado! Id: " + id + ", Tipo: " + Recipe.class.getName()));
    }

    public List<Recipe> findRecipesByIngredient(String ingredientName) {
        return recipeRepository.findRecipesByIngredient(ingredientName);
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
        newObj.setDescription(obj.getDescription());
        newObj.setPrepTime(obj.getPrepTime());
        newObj.setCookTime(obj.getCookTime());
        newObj.setTotalTime(obj.getTotalTime());
        newObj.setServings(obj.getServings());
        newObj.setAuthor(obj.getAuthor());
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
