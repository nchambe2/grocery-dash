import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketTest {

    private PrintStream printStream;
    private Basket basket;
    private Map<String, String> itemsToBePurchased;
    private String item;
    private String itemTwo;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        item = "Item to be purchased";
        itemTwo = "Item two to be purchased";
        itemsToBePurchased = new HashMap<>();
        basket = new Basket(printStream, itemsToBePurchased);
    }


    @Test
    public void shouldDisplaySingleItemInBasketWheOneItemIsToBePurchased() {
        itemsToBePurchased.put("1", item);

        basket.display();

        verify(printStream).println(contains("Item to be purchased"));
    }

    @Test
    public void shouldDisplayTwoItemsInABasketWhenMultipleItemsAreToBePurchased() {
        itemsToBePurchased.put("1", item);
        itemsToBePurchased.put("2", itemTwo);

        basket.display();

        verify(printStream).println(contains("Item to be purchased\nItem two to be purchase"));
    }

    @Test
    public void shouldRemoveItemFromAvailableGroceryItemsWhenAddingAnItemToABasket() {
        basket.add("1", "Juice");

        assertThat(itemsToBePurchased.size(), is(1));
    }

    @Test
    public void shouldDisplaySuccessMessageWhenItemIsAddedToTheBasket() {
        basket.add("1", "Juice");

        verify(printStream).println(contains("Item has been added"));
    }

    @Test
    public void shouldRemoveItemFromBasketWhenCalled() {
        itemsToBePurchased.put("1", item);

        basket.remove(item);

        assertThat(itemsToBePurchased.size(), is(0));
    }

    @Test
    public void shouldDisplaySuccessMessageWhenItemIsRemovedFromBasket() {
        basket.remove("1");

        verify(printStream).println(contains("Item has successfully been removed"));
    }

    @Test
    public void shouldReturnTrueWhenItemIsInBasket() {
        itemsToBePurchased.put("1", item);

        assertThat(basket.isItemInBasket("Item to be purchased"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotInBasket() {
        itemsToBePurchased.put("1", item);

        assertThat(basket.isItemInBasket("Item"), is(false));
    }
}
