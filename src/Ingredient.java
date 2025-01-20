/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Ingredient class - represents an ingredient
 */

 public class Ingredient {
    protected String name;  // name of the ingredient

    /**
     * Constructor to initialize the name of the ingredient.
     * 
     * @param name The name of the ingredient.
     */
    public Ingredient(String name) {
        this.name = name;  
    }

    /**
     * Getter method that returns the name of the ingredient.
     * 
     * @return The name of the ingredient.
     */
    public String getName() {
        return name;  
    }

    /**
     * Override the equals method and compare two Ingredient objects.
     * 
     * @param obj The object to compare with.
     * @return true if the two ingredients are equal (same name), false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;  
        if (obj == null || getClass() != obj.getClass()) return false;  
        Ingredient that = (Ingredient) obj;
        return name != null ? name.equals(that.name) : that.name == null;  
    } // ChatGPT help

    /**
     * Override the toString method and return the ingredient's name as a string
     * 
     * @return The name of the ingredient.
     */
    @Override
    public String toString() {
        return name;  // Return the ingredient's name as a string
    }
}
