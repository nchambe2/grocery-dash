import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InventoryTest {

    private Map<String, Item> availableItems;
    private Inventory inventory;
    private Item itemOne;
    private Item itemTwo;
    private PrintStream printStream;
    private Map<String, Item> itemsToBePurchased;

    @Before
    public void setUp () {
        availableItems = new HashMap<>();
        itemOne = mock(Item.class);
        itemTwo = mock(Item.class);
        printStream = mock(PrintStream.class);
        itemsToBePurchased = new HashMap<>();
        inventory = new Inventory(availableItems, printStream, itemsToBePurchased);
    }

    @Test
    public void shouldListASingleItemWhenOneItemIsAvailable() {
        when(itemOne.details()).thenReturn("Title | Description | Category One | Price | 10");
        availableItems.put("1", itemOne);

        inventory.list();

        verify(printStream).println(contains("1. Title | Description | Category One | Price | 10"));
    }

    @Test
    public void shouldListTwoItemsWhenAreMultipleItemsAvailable() {
        when(itemOne.details()).thenReturn("Title | Description | Category One | Price");
        when(itemTwo.details()).thenReturn("Title Two | Description Two | Category One | Price Two");
        availableItems.put("1", itemOne);
        availableItems.put("2", itemTwo);

        inventory.list();

        verify(printStream).println(contains("1. Title | Description | Category One | Price\n2. Title Two | Description Two | Category One | Price Two"));
    }

    @Test
    public void shouldListASingleItemInACategoryWhenOneItemIsAvailable() {
        when(itemOne.details()).thenReturn("Title | Description | Category One | Price");
        when(itemOne.getCategory()).thenReturn("Category One");
        availableItems.put("1", itemOne);

        inventory.listItemsIn("Category One");

        verify(printStream).println(contains("Title | Description | Category One | "));
    }

    @Test
    public void shouldListTwoItemsInACategoryWheMultipleItemsAreAvailable() {
        when(itemOne.details()).thenReturn("Title | Description | Category One | Price");
        when(itemTwo.details()).thenReturn("Title Two | Description Two | Category One | Price Two");
        when(itemOne.getCategory()).thenReturn("Category One");
        when(itemTwo.getCategory()).thenReturn("Category One");
        availableItems.put("1", itemOne);
        availableItems.put("2", itemTwo);

        inventory.listItemsIn("Category One");

        verify(printStream).println("1. Title | Description | Category One | Price\n2. Title Two | Description Two | Category One | Price Two\n");
    }

    @Test
    public void shouldReturnTrueWhenItemIsInStock() {
        availableItems.put("1", itemOne);

        assertThat(inventory.isItemInStock("1"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotStock() {
        availableItems.put("1", itemOne);

        assertThat(inventory.isItemInStock("1"), is(true));
    }

    @Test
    public void shouldRemoveItemFromAvailableItemsWhenPlacingInBasket() {
        availableItems.put("1", itemOne);

        inventory.addItemToItemsToBePurchased("1");

        assertThat(availableItems.size(), is(0));
    }

    @Test
    public void shouldAddItemToItemsToBePurchasedListWhenPlacingAnItemInTheBasket() {
        availableItems.put("1", itemOne);

        inventory.addItemToItemsToBePurchased("1");

        assertThat(itemsToBePurchased.size(), is(1));
    }

    @Test
    public void shouldDisplaySuccessMessage() {
        availableItems.put("1", itemOne);

        inventory.addItemToItemsToBePurchased("1");

        verify(printStream).println(contains("Item has been added"));
    }

    @Test
    public void shouldAddItemToInventoryWhenCalled() {
        inventory.add("1", itemOne);

        assertThat(availableItems.size(), is(1));
    }

    @Test
    public void shouldDisplaySuccessMessageWhenAddingAnItemToInventory() {
        inventory.add("1", itemOne);

        verify(printStream).println(contains("Item has been placed back on shelf"));
    }

    @Test
    public void shouldSubtractOneFromTheItemsQuantityWhenAddingItemToItemsToBePurchased() {
        availableItems.put("1", itemOne);

        inventory.addItemToItemsToBePurchased("1");

        verify(itemOne).subtractOne();
    }

}