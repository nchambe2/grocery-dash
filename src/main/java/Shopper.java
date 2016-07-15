import java.io.PrintStream;

public class Shopper {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Basket basket;
    private final GroceryCatalog groceryCatalog;

    public Shopper(PrintStream printStream, UserInput userInput, Basket basket, GroceryCatalog groceryCatalog) {

        this.printStream = printStream;
        this.userInput = userInput;
        this.basket = basket;
        this.groceryCatalog = groceryCatalog;
    }

    public void placeItemBackOnShelf() {
        printStream.println("Please select item to place on shelf");

        String itemKey = userInput.getInput();

        if(basket.isItemInBasket(itemKey)) {
            basket.remove(itemKey);
            groceryCatalog.addAvailableItem(itemKey);
        } else {
            printStream.println("Item can not be stocked");
        }

    }

}
