import java.io.PrintStream;
import java.util.Collection;

public class Basket {
    private final PrintStream printStream;
    private final Collection<String> itemsToBePurchased;

    public Basket(PrintStream printStream, Collection<String> itemsToBePurchased) {

        this.printStream = printStream;
        this.itemsToBePurchased = itemsToBePurchased;
    }

    public void display() {
        String itemToBePurchased = "";

        for(String item : itemsToBePurchased) {
            itemToBePurchased += item + "\n";
        }

       printStream.println(itemToBePurchased);
    }

    public void add(String itemToPlaceInBasket) {
        itemsToBePurchased.add(itemToPlaceInBasket);
        printStream.println("Item has been added to your basket.");
    }

    //getting valid input
    //should return only a valid item
    //valid item or not
    //doesn't have to have basket
}
