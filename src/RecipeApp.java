/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Recipe App - A simple app that suggests recipes based on available ingredients.
 */

 import java.util.ArrayList;
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 
 public class RecipeApp {
    /**
     * Main method to run the Recipe App.
     * 
     * @param args Command line arguments (not used).
     * @throws FileNotFoundException If the recipe file is not found.
     */
     public static void main(String[] args) throws FileNotFoundException {
         // "throws FileNotFoundException" was a quick fix
 
         RecipeBook recipeBook = populateRecipeBook();  // Populate the recipe book with recipes from a file
 
         ArrayList<Ingredient> inputedIngredients = getInputedIngredients();  // Get ingredients inputted by the user
 
         displayRecipeType(inputedIngredients);  // Display the classifications of inputted ingredients
         
         // Assigning values to recipes based on matched ingredients
         for (Recipe recipe : recipeBook.getRecipes()) {
             int amount = calculateAmount(recipe, inputedIngredients);  // Calculate how many ingredients match
             recipe.valueAdd(amount);  // Add the matched ingredients' value to the recipe
         }
 
         // Sorting helped by chatGPT
         recipeBook.getRecipes().sort((r1, r2) -> Integer.compare(r2.getValue(), r1.getValue())); 
 
         suggestRecipes(recipeBook);  // Suggest recipes based on the calculated values
 
         chooseRecipe(recipeBook);  // Allow the user to choose a recipe from the suggestions
     }
     
     /**
     * Populates the recipe book by reading from the recipes.txt file.
     * 
     * @return A populated RecipeBook object.
     * @throws FileNotFoundException If the recipe file is not found.
     */
     static RecipeBook populateRecipeBook() throws FileNotFoundException {
         //"throws FileNotFoundException" is a quick fix
         RecipeBook recipeBook = new RecipeBook(new MyLinkedList<>());
         Scanner input = new Scanner(new File("CPT/src/recipes.txt"));
         Recipe currentRecipe = null; 
     
         while (input.hasNextLine()) {
             String line = input.nextLine();
     
             if (line.contains(":")) {
                 String[] parts = line.split(":");
                 String name = parts[0];
                 String type = parts[1].toLowerCase();
     
                 Ingredient ingredient = null;
                 switch (type) {
                     case "protein":
                         ingredient = new Protein(name);
                         break;
                     case "carb":
                         ingredient = new Carb(name);
                         break;
                     case "dairy":
                         ingredient = new Dairy(name);
                         break;
                     case "fruit":
                         ingredient = new Fruit(name);
                         break;
                     case "vegetable":
                         ingredient = new Vegetable(name);
                         break;
                 }
     
                 if (ingredient != null && currentRecipe != null) {
                     currentRecipe.addIngredient(ingredient);  // Add ingredient to current recipe
                 }
             } else {
                 if (currentRecipe != null) {
                     recipeBook.addRecipe(currentRecipe);  // Add the current recipe to the recipe book
                 }
 
                 currentRecipe = new Recipe(line, new ArrayList<>());  // Start a new recipe
             }
         }
 
         if (currentRecipe != null) {
             recipeBook.addRecipe(currentRecipe);  // Add the last recipe to the recipe book
         }
     
 
         return recipeBook;
     }
 
     /**
     * Retrieves the available ingredients from the user.
     * 
     * @return A list of ingredients entered by the user.
     */
     public static ArrayList<Ingredient> getInputedIngredients() {
         Scanner input = new Scanner(System.in);
         ArrayList<Ingredient> ingredients = new ArrayList<>();
 
         System.out.println("Welcome to the Recipe Recommendation App!");
         System.out.println("Enter your available ingredients (press enter to continue):");
 
         
         String inputString = input.nextLine().toLowerCase();
 
             while (!inputString.equals("")) {
                 // Dairy
                 if (Constants.dairy.contains(inputString)) {
                     ingredients.add(new Dairy(inputString));  // Add dairy ingredient
                 } else if (Constants.protein.contains(inputString)) {
                     ingredients.add(new Protein(inputString));  // Add protein ingredient
                 } else if (Constants.carb.contains(inputString)) {
                     ingredients.add(new Carb(inputString));  // Add carb ingredient
                 } else if (Constants.fruit.contains(inputString)) {
                     ingredients.add(new Fruit(inputString));  // Add fruit ingredient
                 } else if (Constants.vegetable.contains(inputString)) {
                     ingredients.add(new Vegetable(inputString));  // Add vegetable ingredient
                 } else {
                     System.out.println("Unknown ingredient.");  // Handle unknown ingredients
                 }
                 inputString = input.nextLine().toLowerCase();
             }
             
             // ".isEmpty()" retrieved online
             if (ingredients.isEmpty()) {
                 System.out.println("You need at least one ingredient.");
                 return getInputedIngredients();  // Recursion to ask for ingredients again
             }
 
         return ingredients;
     }
 
     /**
     * Displays the types of ingredients entered by the user.
     * 
     * @param ingredients The list of ingredients inputted by the user.
     */
     public static void displayRecipeType(ArrayList<Ingredient> ingredients) {
         System.out.println("Classifications:");
 
         for (Ingredient ingredient : ingredients) { 
             System.out.println(ingredient);  // Print each ingredient's classification
         }
         System.out.println("\n");
     }
 
      /**
     * Calculates how many ingredients from the recipe match the ingredients inputted by the user.
     * 
     * @param recipe The recipe to check against the user's input.
     * @param inputedIngredients The list of ingredients inputted by the user.
     * @return The number of matched ingredients.
     */
     public static int calculateAmount(Recipe recipe, ArrayList<Ingredient> inputedIngredients) {
         int amountAdded = 0;
 
         for (Ingredient recipeIngredient : recipe.getIngredients()) {
             for (Ingredient inputedIngredient : inputedIngredients) {
                 if (recipeIngredient.equals(inputedIngredient)) {
                     amountAdded++;  // Increment if the ingredient matches
                 }
             }
         }
 
         return amountAdded;  // Return the total number of matched ingredients
     }
 
     /**
     * Suggests recipes based on the calculated "value".
     * 
     * @param recipeBook The RecipeBook containing all available recipes.
     */
     public static void suggestRecipes(RecipeBook recipeBook) {
         System.out.println("Suggested Recipes:");
         for (Recipe recipe : recipeBook.getRecipes()) {
             if (recipe.getValue() > 0) {
                 // Suggest recipes with high, medium, or low importance
                 if (recipe.getValue() > 2) {
                     System.out.println(recipe.getName() + " (Importance: High (" + recipe.getValue() + " ingredients matched))");
                 } else if (recipe.getValue() > 1) {
                     System.out.println(recipe.getName() + " (Importance: Medium (" + recipe.getValue() + " ingredients matched))");
                 } else {
                     System.out.println(recipe.getName() + " (Importance: Low (" + recipe.getValue() + " ingredient matched))");
                 }
             }
         }
     }
 
     /**
     * Allows the user to choose a recipe from the suggestions and displays its ingredients.
     * 
     * @param recipeBook The RecipeBook containing all available recipes.
     */
     public static void chooseRecipe(RecipeBook recipeBook) {
         Scanner input = new Scanner(System.in);
         System.out.println("\nWould you like to choose a recipe (Y/N)?");
         
         while (yesOrNo()) {
             System.out.println("Choose a recipe.");
 
             String chosenRecipe = input.nextLine().toLowerCase();
             boolean recipeFound = false;
 
             for (Recipe recipe : recipeBook.getRecipes()) {
                 if (chosenRecipe.equals(recipe.getName()) && recipe.getValue() > 0) {
                     recipeFound = true;
                     System.out.println("\nHere are the ingredients needed:");
                     System.out.println(recipe);  // Display the ingredients for the chosen recipe
                     System.out.println("Thank you for using the Recipe Recommendation App! (no further input necessary)");
                     break;
                 }
             }
             
             if (!recipeFound) {
                 System.out.println("\nSorry, recipe not found.");
                 System.out.println("Do you want to quit the app (Y/N)?");
 
                 if (yesOrNo()) {
                     System.out.println("Thank you for using the Recipe Recommendation App! (no further input necessary)");
                     break;
                 } else {
                     System.out.println("Do you want to choose another recipe (Y/N)?");                  
                 }
             }
         }
         
     }
 
     /**
     * Asks the user for a yes or no answer.
     * 
     * @return true if the user inputs Y or y, false if the user inputs N or
     * */
     public static boolean yesOrNo() {
         Scanner input = new Scanner(System.in);
 
         String validation = input.nextLine();
 
         if (validation.equals("Y") || validation.equals("y") ) {
             return true;
         } else if (validation.equals("N") || validation.equals("n")) {
             return false;
         } else {
             System.out.println("Use Y or N to answer");
             return yesOrNo();  // Recursion
         }
     }
 }
 