/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Carb class - represents a carbohydrate ingredient
 */

 public class Carb extends Ingredient {

    /**
     * Constructor to initialize the name of the carb ingredient.
     * 
     * @param name The name of the carbohydrate ingredient.
     */
    public Carb(String name) {
        super(name);  // Call to the superclass (Ingredient) constructor to set the name
    }

    /**
     * Overrides the toString method and returns a string in the format of "name: carb".
     * 
     * @return A string that includes the name of the ingredient followed by ": carb".
     */
    @Override
    public String toString() {
        return name + ": carb";  // Return a string in the format of "name: carb"
    }
}
