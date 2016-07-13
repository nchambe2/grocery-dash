import java.io.PrintStream;

public class BasketValidator {
    private final PrintStream printStream;
    private final UserInput userInput;
    private final Basket basket;
    private final GroceryCatalog groceryCatalog;

    public BasketValidator(PrintStream printStream, UserInput userInput, Basket basket, GroceryCatalog groceryCatalog) {

        this.printStream = printStream;
        this.userInput = userInput;
        this.basket = basket;
        this.groceryCatalog = groceryCatalog;
    }

    //getting valid input
    //should return only a valid item
    //valid item or not
    //doesn't have to have basket
    public void validate() {
        printStream.println("Enter the item you would like to add to your basket");

        String itemToPlaceInBasket = userInput.getInput();

        if(groceryCatalog.findItem(itemToPlaceInBasket)) {
            basket.add(itemToPlaceInBasket);
        } else {
            printStream.println("Item Title Is Not In Stock");
        }

    }
}
