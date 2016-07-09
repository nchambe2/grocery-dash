import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        List<String> availableGroceryItems = new ArrayList<>();
        availableGroceryItems.add("Oscar Meyer Hot Dog");
        availableGroceryItems.add("Tazo Passion Tea");
        ItemCatalog itemCatalog = new ItemCatalog(printStream, availableGroceryItems);
        ApplicationX applicationx = new ApplicationX(itemCatalog);

        applicationx.start();

        //display all items in the grocery store when app starts
        //application
        //Item catalog = contains all items
        //avaliable grocery list = place each individual item into the list
        //item = has a title
    }
}
