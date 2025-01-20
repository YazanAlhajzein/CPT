/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Dairy class - represents a dairy ingredient
 */

 public class Dairy extends Ingredient {

    /**
     * Constructor to initialize the name of the dairy ingredient.
     * 
     * @param name the name of the dairy ingredient
     */
    public Dairy(String name) {
        super(name);  // Call to the superclass (Ingredient) constructor to set the name
    }

    /**
     * Override the toString method and returns a string in the format of "name: dairy"
     * 
     * @return A string that includes the name of the ingredient followed by ": dairy"
     */
    @Override
    public String toString() {
        return name + ": dairy";  // Return a string in the format of "name: dairy"
    }
}
