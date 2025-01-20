import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

import org.junit.jupiter.api.Test;

public class MyLinkedListTest {
    @Test
    void testAppend() {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(10);

        // Act
        list.prepend(5);

        // Assert
        assertEquals("[ 5 -> 10 ]", list.toString()); //AI help
    }

    @Test
    void testGetFirst() throws OperationNotSupportedException {
        // "throws OperationNotSupportedException" is a quick fix
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(10);

        // Act
        Integer firstElement = list.getFirst();

        // Assert
        assertEquals(Integer.valueOf(10), firstElement); //slight AI help
    }

    @Test
    void testIsEmpty() {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Assert
        assertTrue(list.isEmpty());

        // Act
        list.append(10);

        // Assert
        assertFalse(list.isEmpty());
    }

    @Test
    void testIterator() {
        //AI help
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(10);
        list.append(20);
        list.append(30);

        // Act & Assert
        Iterator<Integer> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(10), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(20), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(30), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testPrepend() {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(9);

        // Act
        list.prepend(5);

        // Assert
        assertEquals("[ 5 -> 9 ]", list.toString());
    }

    @Test
    void testRemoveFirst() {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(10);
        list.append(20);

        // Act
        list.removeFirst();

        // Assert
        assertEquals("[ 20 ]", list.toString()); //AI help
    }

    @Test
    void testSize() throws OperationNotSupportedException {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(10);
        list.append(20);

        // Act
        int size = list.size();

        // Assert
        assertEquals(2, size);
    }

    @Test
    void testSort() {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(21);
        list.append(12);
        list.append(20);

        // Act
        list.sort(Comparator.naturalOrder()); //AI

        // Assert
        assertEquals("[ 12 -> 20 -> 21 ]", list.toString());
    }

    @Test
    void testToString() {
        // Arrange
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.append(10);
        list.append(20);

        // Act
        String result = list.toString();

        // Assert
        assertEquals("[ 10 -> 20 ]", result);
    }
}
