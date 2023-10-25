package com.example.springapp.config;

import com.example.springapp.entity.Ingredient;
import com.example.springapp.entity.RegistrationForm;
import com.example.springapp.entity.Type;
import com.example.springapp.entity.User;
import com.example.springapp.mapper.UserMapper;
import com.example.springapp.repository.IngredientRepository;
import org.mapstruct.MapperConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo){
        return args -> {
            repo.save(new Ingredient("FLTO", "Four Tortilla", Type.WRAP));
            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            repo.save(new Ingredient("TMTO", "Diced Tomato", Type.VEGGIES));
            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            repo.save(new Ingredient("JACK", "Monterry Jack", Type.CHEESE));
            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            repo.save(new Ingredient("SRCA", "Sour Cream", Type.SAUCE));
        };
    }
}
