import java.io.PrintStream;
import java.util.Map;

public class GroceryCatalog {
    private final Map<String, String> availableItems;
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Basket basket;

    public GroceryCatalog(Map<String, String> availableItems, PrintStream printStream, UserInput userInput, Basket basket) {
        this.availableItems = availableItems;
        this.printStream = printStream;
        this.userInput = userInput;
        this.basket = basket;
    }

    //contains
    //return true if you find it in the loop
    //false
    //no local variable

    public void list(Map<String, String> groceryCollection) {
        String itemsToDisplay = "";

        for(Map.Entry<String, String> item : groceryCollection.entrySet()) {
          itemsToDisplay += item.getKey() + ". " + item.getValue() + "\n";
        }

        printStream.println(itemsToDisplay);
    }


    public void listItemsIn(String selectedCategory) {
        String itemsToDisplay = "";

        for(Map.Entry<String, String> item : availableItems.entrySet()) {
            if(item.getValue().contains(selectedCategory)) {
                itemsToDisplay += item.getKey() + ". " + item.getValue() + "\n";
            }
        }

        printStream.println(itemsToDisplay);
    }

    public void shop() {
        printStream.println("Enter the item number that corresponds with the item you would like to add to your basket");

        String itemKey = userInput.getInput();

        if(isItemAvailable(itemKey)){
            String itemToPlaceInBasket = availableItems.remove(itemKey);
            basket.add(itemKey, itemToPlaceInBasket);
        } else {
            printStream.println("Item is not available");
        }

    }

    private boolean isItemAvailable(String itemKey) {
        return availableItems.containsKey(itemKey);
    }

    public void addAvailableItem(String item) {

    }
}
