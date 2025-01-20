/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Fruit class - represents a fruit ingredient.
 */

 public class Fruit extends Ingredient {

    /**
     * Constructor to initialize the name of the fruit ingredient.
     * 
     * @param name The name of the fruit ingredient.
     */
    public Fruit(String name) {
        super(name);  // Call to the superclass (Ingredient) constructor to set the name
    }

    /**
     * Overrides the toString method and returns a string in the format of "name: fruit".
     * 
     * @return A string that includes the name of the ingredient followed by ": fruit".
     */
    @Override
    public String toString() {
        return name + ": fruit";  // Return a string in the format of "name: fruit"
    }
}
