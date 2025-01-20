import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;

public class RecipeApp {
    public static void main(String[] args) throws FileNotFoundException {
        // "throws FileNotFoundException" was a quick fix
        Scanner input = new Scanner(System.in);

        RecipeBook recipeBook = populateRecipeBook();

        ArrayList<Ingredient> inputedIngredients = getInputedIngredients();

        displayType(inputedIngredients);
        
        //assigning values to recipes
        for (Recipe recipe : recipeBook.getRecipes()) {
            int amount = calculateAmount(recipe, inputedIngredients);
            recipe.valueAdd(amount);
        }

        //Sorting helped by chatGPT
        recipeBook.getRecipes().sort((r1, r2) -> Integer.compare(r2.getValue(), r1.getValue())); 

        displayRecipes(recipeBook);

        System.out.println("Would you like to choose a recipe (Y/N)?");
        
        while (yesOrNo()) {
            System.out.println("Choose a recipe.");

            String chosenRecipe = input.nextLine().toLowerCase();
            boolean recipeFound = false;

            for (Recipe recipe : recipeBook.getRecipes()) {
                if (chosenRecipe.equals(recipe.getName())) {
                    recipeFound = true;
                    System.out.println("Here are the ingredients needed:");
                    System.out.println(recipe);
                    break; //found online
                }
            }
            
            if (!recipeFound) {
                System.out.println("Sorry, recipe not found.");
                System.out.println("Do you want to quit (Y/N)?");

                if (yesOrNo()) {
                    break;
                } else {
                    System.out.println("Choose a recipe again? (Y/N)");                   
                }
            }
        }
        input.close();
        
        System.out.println("Thank you for using the Recipe Recommendation App!");

    }

    private static RecipeBook populateRecipeBook() throws FileNotFoundException {
        //"throws FileNotFoundException" is a quick fix
        RecipeBook recipeBook = new RecipeBook(new LinkedList<>());
        Scanner input = new Scanner(new File("CPT/src/recipes.txt"));
        Recipe currentRecipe = null;
    
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
    
            if (line.contains(":")) {
                String[] parts = line.split(":");
                String name = parts[0].trim();
                String type = parts[1].trim().toLowerCase();
    
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
                    currentRecipe.addIngredient(ingredient);
                }
            } else {
                if (currentRecipe != null) {
                    recipeBook.addRecipe(currentRecipe);
                }

                currentRecipe = new Recipe(line, new ArrayList<>());
            }
        }

        if (currentRecipe != null) {
            recipeBook.addRecipe(currentRecipe);
        }
    
        input.close();

        return recipeBook;
    }

    public static ArrayList<Ingredient> getInputedIngredients() {
        Scanner input = new Scanner(System.in);
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        System.out.println("Welcome to the Recipe Recommendation App!");
        System.out.println("Enter your available ingredients (press enter to stop):");

        
        String inputString = input.nextLine().toLowerCase();

            while (!inputString.equals("")) {
                // Dairy
                if (Constants.dairy.contains(inputString)) {
                    ingredients.add(new Dairy(inputString));
                } else if (Constants.protein.contains(inputString)) {
                    ingredients.add(new Protein(inputString));
                } else if (Constants.carb.contains(inputString)) {
                    ingredients.add(new Carb(inputString));
                } else if (Constants.fruit.contains(inputString)) {
                    ingredients.add(new Fruit(inputString));
                } else if (Constants.vegetable.contains(inputString)) {
                    ingredients.add(new Vegetable(inputString));
                } else {
                    System.out.println("Unknown ingredient.");
                }
                inputString = input.nextLine().toLowerCase();
            }
            
            //".isEmpty()"" retrieved online
            if (ingredients.isEmpty()) {
                System.out.println("You need at least one ingredient.");
                return getInputedIngredients();
            }
        
        return ingredients;
    }

    public static void displayType(ArrayList<Ingredient> ingredients) {
        System.out.println("Classifications:");

        for (Ingredient ingredient : ingredients) { 
            System.out.println(ingredient);
        }
        System.out.println("\n");
    }

    public static int calculateAmount(Recipe recipe, ArrayList<Ingredient> inputedIngredients) {
        int amountAdded = 0;

        for (Ingredient recipeIngredient : recipe.getIngredients()) {
            for (Ingredient inputedIngredient : inputedIngredients) {
                if (recipeIngredient.equals(inputedIngredient)) {
                    amountAdded++;
                }
            }
        }

        return amountAdded;
    }

    public static void displayRecipes(RecipeBook recipeBook) {
        System.out.println("Suggested Recipes:");
        for (Recipe recipe : recipeBook.getRecipes()) {
            if (recipe.getValue() > 0) {
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

    public static boolean yesOrNo() {
        Scanner input = new Scanner(System.in);

        String validation = input.nextLine();

        if (validation.equals("Y") || validation.equals("y") ) {
            return true;
        }else if (validation.equals("N") || validation.equals("n")) {
            return false;
        }else {
            System.out.println("Use Y or N to answer");
            return yesOrNo();  // recursion
        }
    }

}