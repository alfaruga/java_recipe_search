
import java.util.ArrayList;

/**
 *
 * @author alfar
 */
public class Recipe {

    private ArrayList<String> recipe;
    private String name;

    public Recipe(String name) {
        this.recipe = new ArrayList<>();
        this.name = name;
    }

    public void addLine(String text) {
        this.recipe.add(text);
    }

    public String getName() {
        return this.name;
    }
    public ArrayList<String> getRecipeDetails(){
        return this.recipe;
    }
    public String getCookingTime(){
        return this.recipe.get(0);
    }
     public String toString(){
         return this.getName() + ", cooking time: " + this.getCookingTime() + "\n";
     }       

}
