/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * RecipeBook class - represents a recipe book
 */

 public class RecipeBook {
    private MyLinkedList<Recipe> recipes;  // List of recipes 

    /**
     * Constructor to initialize the RecipeBook with a list of recipes.
     * 
     * @param recipes The list of recipes to initialize the RecipeBook with.
     */
    public RecipeBook(MyLinkedList<Recipe> recipes) {
        this.recipes = recipes; 
    }

    /**
     * Getter method to return the list of recipes in the RecipeBook.
     * 
     * @return The list of recipes stored in the RecipeBook.
     */
    public MyLinkedList<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Method to add a new recipe to the recipe book.
     * 
     * @param recipe The recipe to be added to the RecipeBook.
     */
    public void addRecipe(Recipe recipe) {
        recipes.append(recipe);  // Append the new recipe to the linked list
    }
}
