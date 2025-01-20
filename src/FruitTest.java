import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FruitTest {
    @Test
    void testToString() {
        // Arrange
        String expectedName = "apple";
        Fruit fruit = new Fruit(expectedName);

        // Act
        String actual = fruit.toString();

        // Assert
        String expected = "apple: fruit";
        assertEquals(expected, actual);
    }
}
