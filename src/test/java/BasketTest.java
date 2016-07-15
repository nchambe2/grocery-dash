import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BasketTest {

    private PrintStream printStream;
    private Basket basket;
    private Map<String, Item> itemsToBePurchased;
    private Item item;
    private Item itemTwo;
    private Inventory inventory;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        item = mock(Item.class);
        itemTwo = mock(Item.class);
        itemsToBePurchased = new HashMap<>();
        inventory = mock(Inventory.class);
        basket = new Basket(printStream, itemsToBePurchased, inventory);
    }


    @Test
    public void shouldDisplayASingleItemWheThereIsOneItemInTheBasket() {
        when(item.details()).thenReturn("Item to be purchased");
        itemsToBePurchased.put("1", item);

        basket.display();

        verify(printStream).println(contains("Item to be purchased"));
    }

    @Test
    public void shouldDisplayTwoItemsWhenThereAreMultipleItemsInTheBasket() {
        when(item.details()).thenReturn("Item to be purchased");
        when(itemTwo.details()).thenReturn("Item two to be purchased");
        itemsToBePurchased.put("1", item);
        itemsToBePurchased.put("2", itemTwo);

        basket.display();

        verify(printStream).println(contains("1. Item to be purchased\n2. Item two to be purchase"));
    }

    @Test
    public void shouldReturnTrueWhenItemIsInBasket() {
        itemsToBePurchased.put("1", item);

        assertThat(basket.isItemInBasket("1"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotInBasket() {
        itemsToBePurchased.put("1", item);

        assertThat(basket.isItemInBasket("2"), is(false));
    }

    @Test
    public void shouldRemoveItemFromItemsToBePurchasedListWhenReturningInventory() {
        itemsToBePurchased.put("1", item);

        basket.returnToInventory("1");

        assertThat(itemsToBePurchased.size(), is(0));
    }

    @Test
    public void shouldPlaceItemBackInTheInventoryWhenPlacingOnShelf(){
        itemsToBePurchased.put("1", item);

        basket.returnToInventory("1");

        verify(inventory).add("1", item);
    }
}
