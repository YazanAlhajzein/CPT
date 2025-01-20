import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProteinTest {
    @Test
    void testToString() {
        // Arrange
        // Arrange
        String expectedName = "chicken";
        Protein protein = new Protein(expectedName);

        // Act
        String actual = protein.toString();

        // Assert
        String expected = "chicken: protein";
        assertEquals(expected, actual);
    }
}
