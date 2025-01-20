/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * RecipeBook Test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class RecipeBookTest {
    @Test
    void testAddRecipe() {
        // Arrange
        MyLinkedList<Recipe> expected = new MyLinkedList<>();
        expected.append(new Recipe("pasta", new ArrayList<>()));
        RecipeBook recipeBook = new RecipeBook(expected);

        // Act
        MyLinkedList<Recipe> actual = recipeBook.getRecipes();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testGetRecipes() {
        // Arrange
        MyLinkedList<Recipe> recipes = new MyLinkedList<>();
        Recipe recipe = new Recipe("salad", new ArrayList<>());
        RecipeBook recipeBook = new RecipeBook(recipes);

        // Act
        recipeBook.addRecipe(recipe);

        // Assert
        boolean containsRecipe = false;
        for (Recipe r : recipes) {
            if (r.equals(recipe)) {
                containsRecipe = true;
                break;
            }
        }
        assertTrue(containsRecipe); //AI help
    }
}
