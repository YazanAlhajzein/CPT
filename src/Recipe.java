import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private int value;

    public Recipe(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getValue() {
        return value;
    }

    public void valueAdd(int amount) {
        value += amount;
    }

    @Override
    public String toString() {
        return ingredients;
    }
}