
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alfar
 */
public class RecipesBook {

    private ArrayList<Recipe> recipesList;

    public RecipesBook() {
        this.recipesList = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        this.recipesList.add(recipe);
    }

    public Recipe getRecipe(String recipesName) {
        Recipe recipe = null;

        for (Recipe item : this.recipesList) {
            if (item.getName().equals(recipesName)) {
                recipe = item;
                break;
            }
        }
        return recipe;
    }

    
    public String printWithCommand(String command) {
        
        Scanner scanner = new Scanner(System.in);
        String recipes = "Recipes:\n";

        switch (command) {
            case "list":
                for (Recipe recipe : this.recipesList) {
                    recipes += recipe;
                }
                return recipes;

            case "find name":
                System.out.println("Searched word:");
                String keyWord = scanner.nextLine();
                
                for (Recipe recipe : this.recipesList) {
                    if (recipe.getName().matches("(.*)" + keyWord + "(.*)")) {
                        recipes += recipe;
                    }
                }
                return recipes;
                
            case "find cooking time":
                System.out.println("Max cooking time:");
                int maxTime = Integer.valueOf(scanner.nextLine());
                for (Recipe recipe : this.recipesList) {
                    if (Integer.valueOf(recipe.getCookingTime()) <= maxTime) {
                        recipes += recipe;
                    }
                }
                return recipes;
                
            case "find ingredient":
                System.out.println("Ingredient:");
                String ingredientToSearch = scanner.nextLine();
                String recipesWithIngredient = "";
                for (Recipe recipe : this.recipesList) {
                    if (recipe.getRecipeDetails().contains(ingredientToSearch)) {
                        recipes += recipe;
                    }
                }
                return recipes;
                
            default:
                return "";
                

        }
    }

}
