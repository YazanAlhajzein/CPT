/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * MyLinkedList class - a linked list class
 */

import java.util.NoSuchElementException;
import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyLinkedList<T> implements Iterable<T> {

    // Instance Variables
    private Node<T> head;

    public MyLinkedList () {
        this.head = null;  // null can only mean empty
    }

    /**
     * Return whether or not our Linked List is empty
     * @return true when the list is empty; false otherwise
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Add some data to the beginning of the list
     * @param data The data to add
     */
    public void prepend(T data) {
        Node<T> node = new Node<>(data);

        // Step 0: Is the list empty?
        if (isEmpty()) {
            this.head = node;
            return;
        }
        // Step 1: Make the "next" of this node point to the current list
        node.next = this.head;
        // Step 2: Make node the "head" of the list
        this.head = node;
    }

    /**
     * Add some data to the end of the list
     * @param data The data to add
     */
    public void append(T data) {
        Node<T> node = new Node<>(data);

        // Step 0: Is the list empty?
        if (isEmpty()) {
            this.head = node;
            return;
        }

        // Step 1: Find the end of the list
        // 1a: Save the current state of head
        Node<T> current = this.head;
        // 1b. Find the node that has a "next" of "null"
        while (current.next != null) {
            // This traverses the list down to the end
            current = current.next;
        }
        // We know for sure that current's .next value HAS TO BE NULL
        // Add the node after the last element
        current.next = node;
    }

    public T getFirst() throws OperationNotSupportedException {
        // Step 0: Is the list empty?
        if (isEmpty()) {
            // Throw an exception! (This means that this operation will cause an error)
            throw new OperationNotSupportedException("Cannot get first element of empty list.");
        }

        // We are safe to grab the data from the head of our list
        return this.head.data;
    }

    public void removeFirst () {
        // Step 0: Is the list empty?
        if (isEmpty()) {
            return;  // No op
        }

        // Remove the first element by setting the "head"
        // of the list to point to the "next" element
        this.head = this.head.next;
    }

    //ChatGPT fix
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public int size() throws OperationNotSupportedException {
        if (isEmpty()) {
            // Throw an exception! (This means that this operation will cause an error)
            throw new OperationNotSupportedException("Cannot get first element of empty list.");
        }
        
        int size = 0;
        Node<T> current = this.head;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return size + 1;
    }
    
    //sort method by chatGPT
    public void sort(Comparator<T> comparator) {
        List<T> list = new ArrayList<>();
        
        // Copy elements from the linked list into a list
        for (T element : this) {
            list.add(element);
        }
    
        // Sort the list
        Collections.sort(list, comparator);
    
        // Clear the current linked list
        this.head = null;
    
        // Rebuild the linked list from the sorted list
        for (T element : list) {
            append(element);  // Using append to add elements in the correct order
        }
    }
    

    /**
     * Return a string representation of our Linked List
     */
    public String toString() {
        // Step 0: Is the list empty?
        if (isEmpty()) {
            return "[]";
        }

        // Traverse the list, adding an element to our string at every node
        StringBuilder repr = new StringBuilder();  // Effecient string building
        repr.append("[ ");
        // Traverse 1: Set up current
        Node<T> current = this.head;
        // Traverse 2: Loop while current (or current.next) is not null
        while (current.next != null) {
            // Traverse 3: Do the thing
            repr.append(current.data);
            repr.append(" -> ");

            // Traverse 4: Go to next node
            current = current.next;
        }
        // This is the last element
        repr.append(current.data);
        repr.append(" ]");

        return repr.toString();
    }


    

    /**
     * A node class to make possilbe a "Singly-Linked-List"
     */
    private class Node<U> {
        private U data;
        private Node<U> next;

        public Node(U data) {
            this.data = data;
        }
        
    }

}