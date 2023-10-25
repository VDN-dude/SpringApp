package com.example.springapp.controller;

//import com.example.springapp.cassandra.TacoUDRUtils;
//import com.example.springapp.cassandra.TacoUDT;
import com.example.springapp.entity.Ingredient;
import com.example.springapp.entity.Taco;
import com.example.springapp.entity.TacoOrder;
import com.example.springapp.entity.Type;
import com.example.springapp.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.name().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder tacoOrder(){
        return new TacoOrder();
    }

    @GetMapping
    public String design(){
        return "design";
    }

    @PostMapping
    public String design(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder){
        if (errors.hasErrors()){
            return "design";
        }
        log.info("Taco adding process {}", taco);
        tacoOrder.addTaco(taco);
        return "redirect:/order/current";
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type){
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getType().equals(type)){
                ingredientList.add(ingredient);
            }
        }
        return ingredientList;
    }
}
