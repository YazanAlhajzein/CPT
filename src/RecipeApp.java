import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class RecipeApp {
    public static void main(String[] args) {
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

        System.out.println("Thank you for using the Recipe Recommendation App!");

        input.close();
    }

    private static RecipeBook populateRecipeBook() {
        //Making ingredients
        Ingredient milk = new Dairy("milk");
        Ingredient egg = new Protein("egg");
        Ingredient flour = new Carb("flour");
        Ingredient cheese = new Dairy("cheese");
        Ingredient banana = new Fruit("banana");
        Ingredient chicken = new Protein("chicken");
        Ingredient lettuce = new Vegetable("lettuce");


        //Making recipes
        ArrayList<Ingredient> pancakeList = new ArrayList<>();
        pancakeList.add(milk);
        pancakeList.add(egg);
        pancakeList.add(flour);
        Recipe pancake = new Recipe("pancakes", pancakeList);

        ArrayList<Ingredient> omeletteList = new ArrayList<>();
        omeletteList.add(egg);
        omeletteList.add(cheese);
        omeletteList.add(flour);
        Recipe omelette = new Recipe("omelette", omeletteList);

        ArrayList<Ingredient> smoothieList = new ArrayList<>();
        smoothieList.add(milk);
        smoothieList.add(banana);
        Recipe smoothie = new Recipe("smoothie", smoothieList);


        //Adding recipes to the recipe book
        LinkedList<Recipe> recipeBookList = new LinkedList<>();
        RecipeBook recipeBook = new RecipeBook(recipeBookList);
        recipeBook.addRecipe(pancake);
        recipeBook.addRecipe(omelette);
        recipeBook.addRecipe(smoothie);
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