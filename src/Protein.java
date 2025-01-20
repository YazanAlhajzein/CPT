/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Protein class - represents a protein ingredient.
 */

 public class Protein extends Ingredient {

    /**
     * Constructor to initialize the name of the protein ingredient.
     * 
     * @param name The name of the protein ingredient.
     */
    public Protein(String name) {
        super(name);  // Call to the superclass (Ingredient) constructor to set the name
    }

    /**
     * Overrides the toString method and returns a string in the format of "name: protein".
     * 
     * @return A string that includes the name of the ingredient followed by ": protein".
     */
    @Override
    public String toString() {
        return name + ": protein";  // Return a string in the format of "name: protein"
    }
}
