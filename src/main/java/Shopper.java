import java.io.PrintStream;

public class Shopper {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Basket basket;
    private final Inventory inventory;

    public Shopper(PrintStream printStream, UserInput userInput, Basket basket, Inventory inventory) {

        this.printStream = printStream;
        this.userInput = userInput;
        this.basket = basket;
        this.inventory = inventory;
    }

    public void shop() {
        printStream.println("Enter the item number that corresponds with the item you would like to add to your basket");

        String itemKey = userInput.getInput();

        if(inventory.isItemInStock(itemKey)) {
            inventory.addItemToItemsToBePurchased(itemKey);
        } else {
            printStream.println("Item is not in stock");
        }
    }

    public void placeItemBackOnShelf() {
        printStream.println("Please select item to place on shelf");

        String itemKey = userInput.getInput();

        if(basket.isItemInBasket(itemKey)) {
            basket.returnToInventory(itemKey);
        } else {
            printStream.println("Item can not be added to inventory");
        }

    }

}
