import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        Menu menu = new Menu(printStream, itemCatalog);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Application applicationx = new Application(menu, bufferedReader);

        applicationx.start();

    }

    //instead of seeing the item automatically
    //display menu option = browse by item
    //get user input
    //if correct browse by item
    //display invalid option
    //prompt again
}
