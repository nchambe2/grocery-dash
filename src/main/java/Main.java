import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        UserInput userInput = new UserInput(bufferedReader);
        Map<String, Item> availableItems = new HashMap<>();
        Item oscarMeyerHotDog = new Item("Oscar Meyer Hot Dog", "Very Tasty Hot Dog", "Meat", "$3.99", 1);
        Item tazoPassionTea = new Item("Tazo Passion Tea", "Flowery Tea", "Tea", "$4.99", 1);
        Item tazoChaiTea = new Item("Tazo Chai Tea", "Spicy black tea", "Tea", "$4.99", 1);
        availableItems.put("1", oscarMeyerHotDog);
        availableItems.put("2", tazoPassionTea);
        Map<String, Item> itemsToBePurchased = new HashMap<>();
        itemsToBePurchased.put("3", tazoChaiTea);
        Inventory inventory = new Inventory(availableItems, printStream, itemsToBePurchased);
        Basket basket = new Basket(printStream, itemsToBePurchased, inventory);
        Map<String, Command> groceryCommands = new HashMap<>();
        Menu menu = new Menu(printStream, groceryCommands);
        Shopper shopper = new Shopper(printStream, userInput, basket, inventory);
        Command viewAvailableItemsCommand = new ViewAvailableItemsCommand(inventory);
        Command viewAvailableItemsInACategoryCommand = new ViewAvailableItemsInACategoryCommand(inventory, printStream, userInput);
        Command viewBasketCommand = new ViewBasketCommand(basket);
        Command addBasketCommand = new AddItemToBasketCommand(shopper);
        Command removeItemFromBasket = new RemoveItemFromBasketCommand(shopper);
        Command quitCommand = new QuitCommand(printStream);
        groceryCommands.put("View Available Items", viewAvailableItemsCommand);
        groceryCommands.put("View Available Items In A Category", viewAvailableItemsInACategoryCommand);
        groceryCommands.put("View Basket", viewBasketCommand);
        groceryCommands.put("Add Item To Basket", addBasketCommand);
        groceryCommands.put("Remove Item From Basket", removeItemFromBasket);
        groceryCommands.put("Quit", quitCommand);
        MenuValidator menuValidator = new MenuValidator(printStream, groceryCommands);
        Application application = new Application(menu, menuValidator, printStream, userInput);

        application.start();

    }

}
