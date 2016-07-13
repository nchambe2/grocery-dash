import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketTest {

    private GroceryCatalog groceryCatalog;
    private PrintStream printStream;
    private Basket basket;
    private Collection<Item> itemsToBePurchased;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        groceryCatalog = mock(GroceryCatalog.class);
        itemsToBePurchased = new ArrayList<>();
        basket = new Basket(printStream, groceryCatalog, itemsToBePurchased);
    }

    @Test
    public void shouldDisplayBasketIsEmptyMessageWhenThereAreNoItemsInTheBasket() {
        basket.display();

        verify(printStream).println(contains("basket is empty"));
    }

    @Test
    public void shouldRemoveItemFromAvailableGroceryItemsWhenAddingAnItemToABasket() {
        basket.add("Juice");

        //verify(groceryCatalog).remove()
    }
}
