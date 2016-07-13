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
        Collection<Item> availableGroceryItems = new ArrayList<>();
        Collection<String> availableCategories = new ArrayList<>();
        String meat = "Meat";
        String tea = "Tea";
        availableCategories.add(meat);
        availableCategories.add(tea);
        Item oscarMeyerHotDog = new Item("Oscar Meyer Hot Dog", "Very Tasty Hot Dog", meat, "$3.99");
        Item tazoPassionTea = new Item("Tazo Passion Tea", "Flowery Tea", tea, "$4.99");
        availableGroceryItems.add(oscarMeyerHotDog);
        availableGroceryItems.add(tazoPassionTea);
        Map<String, Command> groceryCommands = new HashMap<>();
        GroceryCatalog groceryCatalog = new GroceryCatalog(availableGroceryItems, availableCategories);
        Menu menu = new Menu(printStream, groceryCommands);
        Collection<Item> itemsToBePurchased = new ArrayList<>();
        Basket basket = new Basket(printStream, groceryCatalog, itemsToBePurchased);
        BasketValidator basketValidator = new BasketValidator(printStream, userInput, basket, groceryCatalog);
        Command browseAvailableItemsCommand = new BrowseAvailableItemsCommand(groceryCatalog, printStream);
        Command browseAvailableCategoriesCommand = new BrowseAvailableCategoriesCommand(groceryCatalog, printStream);
        Command browseAvailableItemsInACategoryCommand = new BrowseAvailableItemsInACategoryCommand(groceryCatalog, printStream, userInput);
        Command viewBasketCommand = new ViewBasketCommand(basket);
        Command addBasketCommand = new AddItemToBasketCommand(basketValidator);
        groceryCommands.put("Browse Available Items", browseAvailableItemsCommand);
        groceryCommands.put("Browse Available Categories", browseAvailableCategoriesCommand);
        groceryCommands.put("Browse Available Items In A Category", browseAvailableItemsInACategoryCommand);
        groceryCommands.put("View Basket", viewBasketCommand);
        groceryCommands.put("Add Item To Basket", addBasketCommand);
        MenuValidator menuValidator = new MenuValidator(printStream, userInput, groceryCommands);
        Application application = new Application(menu, menuValidator, printStream);

        application.start();

    }

}
