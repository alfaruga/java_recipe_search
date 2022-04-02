
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File to read:");

        String file = scanner.nextLine();
        RecipesBook book = new RecipesBook();

        try ( Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                //this creates a new Recipe

                String name = reader.nextLine();

                book.addRecipe(new Recipe(name));

                /*This adds lines until there's a blank. When
                when a blank is found, it breaks and add a new recipe*/
                if (!reader.hasNextLine()) {
                    break;
                }
                String recipeBody = reader.nextLine();
                while (!recipeBody.isEmpty()) {
                    book.getRecipe(name).addLine(recipeBody);
                    recipeBody = reader.nextLine();
                }

            }
        } catch (Exception e) {

        }
        System.out.println(
                "Commands:\n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient");

        while (true) {

            System.out.println("Enter command:");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            
            System.out.println(book.printWithCommand(command));

             
            
            
     
        }

    }

}
