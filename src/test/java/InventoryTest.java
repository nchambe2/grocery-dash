import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InventoryTest {

    private Map<String, String> availableItems;
    private Inventory inventory;
    private String itemOne;
    private Map<String, String> availableCategories;
    private String categoryOne;
    private String itemTwo;
    private String categoryTwo;
    private PrintStream printStream;
    private Map<String, String> itemsToBePurchased;

    @Before
    public void setUp () {
        availableItems = new HashMap<>();
        itemOne = "Title | Description | Category One | Price";
        itemTwo = "Title Two | Description Two | Category One | Price Two";
        availableCategories = new HashMap<>();
        categoryOne = "Category One";
        categoryTwo = "Category Two";
        printStream = mock(PrintStream.class);
        itemsToBePurchased = new HashMap<>();
        inventory = new Inventory(availableItems, printStream, itemsToBePurchased);
    }

    @Test
    public void shouldListASingleItemWhenOneItemIsAvailable() {
        availableItems.put("1", itemOne);

        inventory.list(availableItems);

        verify(printStream).println(contains("1. Title | Description | Category One | Price"));
    }

    @Test
    public void shouldListTwoItemsWhenAreMultipleItemsAvailable() {
        availableItems.put("1", itemOne);
        availableItems.put("2", itemTwo);

        inventory.list(availableItems);

        verify(printStream).println(contains("1. Title | Description | Category One | Price\n2. Title Two | Description Two | Category One | Price Two"));
    }

    @Test
    public void shouldListASingleCategoryWhenOneCategoryIsAvailable() {
        availableCategories.put("1", categoryOne);

        inventory.list(availableCategories);

        verify(printStream).println(contains("1. Category One"));
    }

    @Test
    public void shouldListTwoCategoriesWhenThereAreMultipleCategoriesAvailable() {
        availableCategories.put("1", categoryOne);
        availableCategories.put("2", categoryTwo);

        inventory.list(availableCategories);

        verify(printStream).println(contains("1. Category One\n2. Category Two"));
    }

    @Test
    public void shouldListASingleItemInACategoryWhenOneItemIsAvailable() {
        availableItems.put("1", itemOne);

        inventory.listItemsIn("Category One");

        verify(printStream).println(contains("Title | Description | Category One | "));
    }

    @Test
    public void shouldListTwoItemsInACategoryWheMultipleItemsAreAvailable() {
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

        verify(printStream).println(contains("successfully been removed"));
    }

}