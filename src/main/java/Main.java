import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserInput userInput = new UserInput(bufferedReader);
        Map<String, String> availableGroceryItems = new HashMap<>();
        Map<String, String> availableCategories = new HashMap<>();
        String meat = "Meat";
        String tea = "Tea";
        availableCategories.put("1", meat);
        availableCategories.put("2", tea);
        String oscarMeyerHotDog = String.join(" | ", "Oscar Meyer Hot Dog", "Very Tasty Hot Dog", meat, "$3.99");
        String tazoPassionTea = String.join(" | ", "Tazo Passion Tea", "Flowery Tea", tea, "$4.99");
        availableGroceryItems.put("1", oscarMeyerHotDog);
        availableGroceryItems.put("2", tazoPassionTea);
        Collection<String> itemsToBePurchased = new ArrayList<>();
        Basket basket = new Basket(printStream, itemsToBePurchased);
        Map<String, Command> groceryCommands = new HashMap<>();
        GroceryCatalog groceryCatalog = new GroceryCatalog(availableGroceryItems, printStream, userInput, basket);
        Menu menu = new Menu(printStream, groceryCommands);
        Command browseAvailableItemsCommand = new ViewAvailableItemsCommand(availableGroceryItems, groceryCatalog);
        Command browseAvailableCategoriesCommand = new ViewAvailableCategoriesCommand(groceryCatalog, availableCategories);
        Command browseAvailableItemsInACategoryCommand = new ViewAvailableItemsInACategoryCommand(groceryCatalog, printStream, userInput);
        Command viewBasketCommand = new ViewBasketCommand(basket);
        Command addBasketCommand = new AddItemToBasketCommand(groceryCatalog);
        groceryCommands.put("View Available Items", browseAvailableItemsCommand);
        groceryCommands.put("View Available Categories", browseAvailableCategoriesCommand);
        groceryCommands.put("View Available Items In A Category", browseAvailableItemsInACategoryCommand);
        groceryCommands.put("View Basket", viewBasketCommand);
        groceryCommands.put("Add Item To Basket", addBasketCommand);
        MenuValidator menuValidator = new MenuValidator(printStream, userInput, groceryCommands);
        Application application = new Application(menu, menuValidator, printStream);

        application.start();

    }

}
