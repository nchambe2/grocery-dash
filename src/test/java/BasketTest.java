import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketTest {

    private PrintStream printStream;
    private Basket basket;
    private Collection<String> itemsToBePurchased;
    private String item;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        item = "Item to be purchased";
        itemsToBePurchased = new ArrayList<>();
        basket = new Basket(printStream, itemsToBePurchased);
    }


    @Test
    public void shouldDisplaySingleItemInBasketWheOneItemIsToBePurchased() {
        itemsToBePurchased.add(item);

        basket.display();

        verify(printStream).println(contains("Item to be purchased"));
    }

    @Test
    public void shouldRemoveItemFromAvailableGroceryItemsWhenAddingAnItemToABasket() {
        basket.add("Juice");

        assertThat(itemsToBePurchased.size(), is(1));
    }

    @Test
    public void shouldDisplaySuccessMessageWhenItemIsAddedToTheBasket() {
        basket.add("Juice");

        verify(printStream).println(contains("Item has been added"));
    }
}
