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
        Collection<Category> availableCategories = new ArrayList<>();
        Category meat = new Category("Meat");
        Category tea = new Category("Tea");
        availableCategories.add(meat);
        availableCategories.add(tea);
        Item oscarMeyerHotDog = new Item("Oscar Meyer Hot Dog", "Very Tasty Hot Dog", meat, "$3.99");
        Item tazoPassionTea = new Item("Tazo Passion Tea", "Flowery Tea", tea, "$4.99");
        availableGroceryItems.add(oscarMeyerHotDog);
        availableGroceryItems.add(tazoPassionTea);
        Map<String, Command> groceryCommands = new HashMap<>();
        ItemCatalog itemCatalog = new ItemCatalog(availableGroceryItems, availableCategories);
        Menu menu = new Menu(printStream, groceryCommands);
        Basket basket = new Basket(printStream);
        Command browseAvailableItemsCommand = new BrowseAvailableItemsCommand(itemCatalog, printStream);
        Command browseAvailableCategoriesCommand = new BrowseAvailableCategoriesCommand(itemCatalog, printStream);
        Command browseAvailableItemsInACategoryCommand = new BrowseAvailableItemsInACategoryCommand(itemCatalog, printStream, userInput);
        Command viewBasketCommand = new ViewBasketCommand(basket);
        Command addBasketCommand = new AddItemToBasketCommand(basket);
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
