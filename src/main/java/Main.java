import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Collection<Item> availableGroceryItems = new ArrayList<>();
        Item oscarMeyerHotDog = new Item("Oscar Meyer Hot Dog");
        Item tazoPassionTea = new Item("Tazo Passion Tea");
        availableGroceryItems.add(oscarMeyerHotDog);
        availableGroceryItems.add(tazoPassionTea);
        ItemCatalog itemCatalog = new ItemCatalog(printStream, availableGroceryItems);
        Application applicationx = new Application(itemCatalog);

        applicationx.start();

        //display all items in the grocery store when app starts
        //application
        //Item catalog = contains all items
        //avaliable grocery list = place each individual item into the list
        //item = has a title
    }
}
