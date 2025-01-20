/**
 * author: Yazan Alhajzein
 * date: 01/19/2025
 * Constants class - contains a list of different types of items
 */

 import java.util.Arrays;
 import java.util.HashSet;
 
 public final class Constants {
 
     // HashSet to store dairy-related items
     public static HashSet<String> dairy = new HashSet<>(
         Arrays.asList(
             "milk", "yogurt", "cheese", "butter", "cream", "cream cheese", "cottage cheese", "greek yogurt", "feta cheese", "mozzarella"
             )
         );
 
     // HashSet to store protein-related items
     public static HashSet<String> protein = new HashSet<>(
         Arrays.asList(
             "egg powder", "tofu", "protein powder", "chicken", "salmon", "tuna", "beans", "lentils", "almonds", "chia seeds", "peanut butter", "hummus", "falafel", "beef", "fish"
             )
         );
 
     // HashSet to store fruit-related items
     public static HashSet<String> fruit = new HashSet<>(
         Arrays.asList(
             "banana", "strawberry", "apple", "orange", "grapes", "mango", "blueberry", "peach", "kiwi", "melon", "lemon", "lime", "raisins"
             )
         );
 
     // HashSet to store vegetable-related items
     public static HashSet<String> vegetable = new HashSet<>(
         Arrays.asList(
             "spinach", "lettuce", "tomato", "cucumber", "carrot", "broccoli", "bell pepper", "potato", "sweet potato", "avocado", "onion", "garlic", "zucchini", "eggplant", "peas", "asparagus", "cabbage", "basil", "romaine lettuce", "cauliflower"
             )
         );
 
     // HashSet to store carbohydrate-related items
     public static HashSet<String> carb = new HashSet<>(
         Arrays.asList(
             "flour", "bread", "pasta", "rice", "tortilla", "granola", "oats", "sugar", "cinnamon", "honey", "olive oil", "mayo", "crackers", "pita", "noodles", "croutons"
             )
         );
 }
 