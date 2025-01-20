/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Vegetable Test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VegetableTest {
    @Test
    void testToString() {
        // Arrange
        String expectedName = "lettuce";
        Vegetable vegetable = new Vegetable(expectedName);

        // Act
        String actual = vegetable.toString();

        // Assert
        String expected = "lettuce: vegetable";
        assertEquals(expected, actual);
    }
}
