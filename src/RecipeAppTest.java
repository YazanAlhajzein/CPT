import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Test;

public class RecipeAppTest {
    @Test
    void testCalculateAmount() throws FileNotFoundException {
         // Arrange
         ArrayList<Ingredient> inputedIngredients = new ArrayList<>();
         inputedIngredients.add(new Carb("rice"));
         inputedIngredients.add(new Protein("chicken"));
 
         Recipe recipe = new Recipe("recipe 1", new ArrayList<>());
         recipe.addIngredient(new Carb("rice"));
         recipe.addIngredient(new Protein("chicken"));
         recipe.addIngredient(new Vegetable("carrot"));
 
         // Act
         int actual = RecipeApp.calculateAmount(recipe, inputedIngredients);
 
         // Assert
         int expected = 2;  // Two matching ingredients: Rice and Chicken
         assertEquals(expected, actual);
    }



    @Test
    void testGetInputedIngredients() {
        // Arrange
        Recipe recipe = new Recipe("chicken rice", new ArrayList<>());
        recipe.addIngredient(new Carb("rice"));
        recipe.addIngredient(new Protein("chicken"));

        ArrayList<Ingredient> inputedIngredients = new ArrayList<>();
        inputedIngredients.add(new Carb("rice"));
        inputedIngredients.add(new Protein("chicken"));

        int expected = 2;

        // Act
        int actual = RecipeApp.calculateAmount(recipe, inputedIngredients);

        // Assert
        assertEquals(expected, actual);
    }


    @Test
    void testPopulateRecipeBook() throws FileNotFoundException, OperationNotSupportedException {
        // Arrange
        RecipeBook recipe = new RecipeBook(new MyLinkedList<>());
        recipe.addRecipe(new Recipe("fried Rice", new ArrayList<>()));
        recipe.addRecipe(new Recipe("salad", new ArrayList<>())); //size = 2

        int expectedSize = 435; //size of recipes.txt

        // Act
        RecipeBook actual = RecipeApp.populateRecipeBook();
        assertEquals(expectedSize, actual.getRecipes().size());
    }

    @Test
    void testYesOrNo() {
         // Arrange
        String userInput = "Y\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes()); //Gotten from chatGPT
        System.setIn(inputStream);

        // Act & Assert
        assertTrue(RecipeApp.yesOrNo());

        userInput = "N\n";
        inputStream = new ByteArrayInputStream(userInput.getBytes()); //Gotten from chatGPT
        System.setIn(inputStream);

        assertFalse(RecipeApp.yesOrNo());

    }
}
