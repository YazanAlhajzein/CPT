import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarbTest {
    @Test
    void testToString() {
        // Arrange
        String expectedName = "rice";
        Carb carb = new Carb(expectedName);

        // Act
        String actual = carb.toString();

        // Assert
        String expected = "rice: carb";
        assertEquals(expected, actual);
    }
}
