package com.example.springapp.converter;

import com.example.springapp.entity.Ingredient;
import com.example.springapp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    @Autowired
    private IngredientRepository ingredientRepository;

//    public IngredientByIdConverter() {
//        ingredientMap.put("FLTO", new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//        ingredientMap.put("COTO", new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//        ingredientMap.put("GRBF", new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//        ingredientMap.put("CARN", new Ingredient("CARN", "CArnitas", Type.PROTEIN));
//        ingredientMap.put("TMTO", new Ingredient("TMTO", "Diced Tomato", Type.VEGGIES));
//        ingredientMap.put("LETC", new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//        ingredientMap.put("CHED", new Ingredient("CHED", "Cheddar", Type.CHEESE));
//        ingredientMap.put("JACK", new Ingredient("JACK", "Monterry Jack", Type.CHEESE));
//        ingredientMap.put("SLSA", new Ingredient("SLSA", "Salsa", Type.SAUCE));
//        ingredientMap.put("SRCA", new Ingredient("SRCA", "Sour Cream", Type.SAUCE));
//    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepository.findById(source).orElse(null);
    }
}
