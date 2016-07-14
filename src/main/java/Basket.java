import java.io.PrintStream;
import java.util.Collection;

public class Basket {
    private final PrintStream printStream;

    public Basket(PrintStream printStream, GroceryCatalog groceryCatalog, Collection<String> itemsToBePurchased) {

        this.printStream = printStream;
    }

    public void display() {
        printStream.println("This basket is empty");
    }

    public void add(String itemToPlaceInBasket) {

    }

    //prompt a user to enter a item
    //get user input
    //validate user input
    //add the item to a itemsToBePurchased collection
    //remove from available collection
}
