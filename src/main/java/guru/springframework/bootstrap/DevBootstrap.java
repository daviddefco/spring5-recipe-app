package guru.springframework.bootstrap;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Guacamole ingredients
        Set<Ingredient> guacamoleIngredients = new HashSet<>();
        guacamoleIngredients.add(new Ingredient(
            "avocado",
            BigDecimal.valueOf(2),
            unitOfMeasureRepository.findByDescription("Unit").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "salt",
                BigDecimal.valueOf(0.5),
                unitOfMeasureRepository.findByDescription("Teaspoon").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "fresh lime juice",
                BigDecimal.valueOf(1),
                unitOfMeasureRepository.findByDescription("Tablespoon").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "minced red onion",
                BigDecimal.valueOf(0.5),
                unitOfMeasureRepository.findByDescription("Cup").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "minced serrano chiles",
                BigDecimal.valueOf(2),
                unitOfMeasureRepository.findByDescription("Unit").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "chopped cilantro",
                BigDecimal.valueOf(2),
                unitOfMeasureRepository.findByDescription("Trablespoon").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "black pepper",
                BigDecimal.valueOf(1),
                unitOfMeasureRepository.findByDescription("Dash").get()
        ));
        guacamoleIngredients.add(new Ingredient(
                "chopped tomato",
                BigDecimal.valueOf(0.5),
                unitOfMeasureRepository.findByDescription("Unit").get()
        ));
        // Guacamole
        Recipe guacamole = new Recipe("How to MAke Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
        guacamole.setIngredients(guacamoleIngredients);
        guacamole.setDirections("Cut avocado, remove flesh");
    }
}
