/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * RecipeTest class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RecipeTest {
    @Test
    void testAddIngredient() {
        // Arrange
        String expected = "pasta";
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Recipe recipe = new Recipe(expected, ingredients);

        // Act
        String actual = recipe.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetIngredients() {
        // Arrange
        ArrayList<Ingredient> expected = new ArrayList<>();
        expected.add(new Carb("rice"));
        Recipe recipe = new Recipe("broccoli rice", expected);

        // Act
        ArrayList<Ingredient> actual = recipe.getIngredients();

        // Assert
        assertEquals(expected, actual);
    }   

    @Test
    void testGetName() {
        // Arrange
        String expected = "pasta";
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        Recipe recipe = new Recipe(expected, ingredients);

        // Act
        String actual = recipe.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetValue() {
        // Arrange
        Recipe recipe = new Recipe("pasta", new ArrayList<>());

        // Act
        int actual = recipe.getValue();
        int expected = 0;

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        // Arrange
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Carb("rice"));
        ingredients.add(new Protein("chicken"));
        Recipe recipe = new Recipe("broccoli rice", ingredients);

        // Act
        String actual = recipe.toString();

        // Assert
        String expected = "- rice: carb\n- chicken: protein\n";
        assertEquals(expected, actual);
    }

    @Test
    void testValueAdd() {
        Recipe recipe = new Recipe("pasta", new ArrayList<>());
        int expected = 2;

        // Act
        recipe.valueAdd(expected);
        int actual = recipe.getValue();

        // Assert
        assertEquals(expected, actual);
    }
}
