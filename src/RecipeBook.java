import java.util.LinkedList; //Asked chatgpt about the inclusion of the linked list and it suggested simply replacing the arraylist here with a linked list

public class RecipeBook {
    private LinkedList<Recipe> recipes;

    public RecipeBook(LinkedList<Recipe> recipes) {
        this.recipes = recipes;
    }

    public LinkedList<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}