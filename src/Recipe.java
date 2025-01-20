/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Recipe class - represents a recipe 
 */

 import java.util.ArrayList;

 public class Recipe {
     private String name;  // Name of the recipe
     private ArrayList<Ingredient> ingredients; // List of ingredients (composition)
     private int value;  // Value of the recipe (importance)
 
     /**
      * Constructor to initialize a recipe with a name and a list of ingredients.
      * 
      * @param name The name of the recipe.
      * @param ingredients The list of ingredients in the recipe.
      */
     public Recipe(String name, ArrayList<Ingredient> ingredients) {
         this.name = name;
         this.ingredients = ingredients;  
         this.value = 0;  // Initial value set to 0
     }
 
     /**
      * Getter method to return the name of the recipe.
      * 
      * @return The name of the recipe.
      */
     public String getName() {
         return name;
     }
 
     /**
      * Getter method to return the list of ingredients in the recipe.
      * 
      * @return The list of ingredients in the recipe.
      */
     public ArrayList<Ingredient> getIngredients() {
         return ingredients;
     }
 
     /**
      * Getter method to return the value of the recipe.
      * 
      * @return The value of the recipe, indicating its importance.
      */
     public int getValue() {
         return value;
     }
 
     /**
      * Method to add a value (importance) to the recipe.
      * 
      * @param amount The amount of value to add to the recipe.
      */
     public void valueAdd(int amount) {
         value += amount;  // Increment the recipe's value by the given amount
     }
 
     /**
      * Method to add a new ingredient to the recipe.
      * 
      * @param ingredient The ingredient to add to the recipe.
      */
     public void addIngredient(Ingredient ingredient) {
         ingredients.add(ingredient);  // Add the ingredient to the list
     }
 
     /**
      * Override the toString method to return a string representation of the recipe.
      * 
      * @return A formatted string of the recipe's ingredients.
      */
     @Override
     public String toString() {
         String recipe = "";
         for (Ingredient ingredient : ingredients) {
             recipe += "- " + ingredient + "\n";  // Add each ingredient to the recipe string
         }
 
         return recipe;  // Return the formatted recipe string
     }
 }
 