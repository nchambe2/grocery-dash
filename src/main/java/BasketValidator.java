import java.io.PrintStream;

public class BasketValidator {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Basket basket;
    private final ItemCatalog itemCatalog;

    public BasketValidator(PrintStream printStream, UserInput userInput, Basket basket, ItemCatalog itemCatalog) {

        this.printStream = printStream;
        this.userInput = userInput;
        this.basket = basket;
        this.itemCatalog = itemCatalog;
    }

    public void validate() {
        printStream.println("Enter the item you would like to add to your basket");

        String itemToPlaceInBasket = userInput.getInput();

        if(itemCatalog.findItem(itemToPlaceInBasket)) {
            basket.add();
        } else {
            printStream.println("Item Title Is Not In Stock");
        }

    }
}
