/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Dairy Test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DairyTest {
    @Test
    void testToString() {
        // Arrange
        String expectedName = "milk";
        Dairy dairy = new Dairy(expectedName);

        // Act
        String actual = dairy.toString();

        // Assert
        String expected = "milk: dairy";
        assertEquals(expected, actual);
    }
}
