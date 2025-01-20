/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Vegetable class - represents a vegetable ingredient.
 */

 public class Vegetable extends Ingredient {

    /**
     * Constructor to initialize the name of the vegetable ingredient.
     * 
     * @param name The name of the vegetable ingredient.
     */
    public Vegetable(String name) {
        super(name);  // Call to the superclass (Ingredient) constructor to set the name
    }

    /**
     * Overrides the toString method and returns a string in the format of "name: vegetable".
     * 
     * @return A string that includes the name of the ingredient followed by ": vegetable".
     */
    @Override
    public String toString() {
        return name + ": vegetable";  // Return a string in the format of "name: vegetable"
    }
}
