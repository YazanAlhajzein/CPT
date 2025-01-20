/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Ingredient Test class
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IngredientTest {
    @Test
    void testEquals() {
        // Arrange
        Ingredient ingredient1 = new Ingredient("sugar");
        Ingredient ingredient2 = new Ingredient("sugar");
        Ingredient ingredient3 = new Ingredient("salt");

        // Act & Assert
        assertTrue(ingredient1.equals(ingredient2));

        assertFalse(ingredient1.equals(ingredient3)); //Researched assertTrue & assertFalse
    }

    @Test
    void testGetName() {
        // Arrange
        String expected = "sugar";
        Ingredient ingredient = new Ingredient(expected);

        // Act
        String actual = ingredient.getName();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testToString() {
        // Arrange
        String expected = "sugar";
        Ingredient ingredient = new Ingredient(expected);

        // Act
        String actual = ingredient.toString();

        // Assert
        assertEquals(expected, actual);
    }
}
