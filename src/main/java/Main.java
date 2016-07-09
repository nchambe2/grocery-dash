import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        Collection<Item> availableGroceryItems = new ArrayList<>();
        Item oscarMeyerHotDog = new Item("Oscar Meyer Hot Dog", "Very Tasty Hot Dog", "Meat", "$3.99");
        Item tazoPassionTea = new Item("Tazo Passion Tea", "Flowery Tea", "Tea", "$4.99");
        availableGroceryItems.add(oscarMeyerHotDog);
        availableGroceryItems.add(tazoPassionTea);
        ItemCatalog itemCatalog = new ItemCatalog(printStream, availableGroceryItems);
        Menu menu = new Menu(printStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        MenuValidator menuValidator = new MenuValidator(itemCatalog, printStream);
        Application application = new Application(menu, menuValidator, bufferedReader);

        application.start();

    }
}
