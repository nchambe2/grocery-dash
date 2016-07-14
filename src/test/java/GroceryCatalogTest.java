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

public class GroceryCatalogTest {

    private Map<String, String> availableGroceryItems;
    private GroceryCatalog groceryCatalog;
    private String itemOne;
    private Map<String, String> availableCategories;
    private String categoryOne;
    private String itemTwo;
    private String categoryTwo;
    private PrintStream printStream;
    private UserInput userInput;
    private Basket basket;

    @Before
    public void setUp () {
        availableGroceryItems = new HashMap<>();
        itemOne = "Title | Description | Category One | Price";
        itemTwo = "Title Two | Description Two | Category One | Price Two";
        availableCategories = new HashMap<>();
        categoryOne = "Category One";
        categoryTwo = "Category Two";
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        basket = mock(Basket.class);
        groceryCatalog = new GroceryCatalog(availableGroceryItems, printStream, userInput, basket);
    }

    @Test
    public void shouldListASingleItemWhenOneItemIsAvailable() {
        availableGroceryItems.put("1", itemOne);

        groceryCatalog.list(availableGroceryItems);

        verify(printStream).println(contains("1. Title | Description | Category One | Price"));
    }

    @Test
    public void shouldListTwoItemsWhenAreMultipleItemsAvailable() {
        availableGroceryItems.put("1", itemOne);
        availableGroceryItems.put("2", itemTwo);

        groceryCatalog.list(availableGroceryItems);

        verify(printStream).println(contains("1. Title | Description | Category One | Price\n2. Title Two | Description Two | Category One | Price Two"));
    }

    @Test
    public void shouldListASingleCategoryWhenOneCategoryIsAvailable() {
        availableCategories.put("1", categoryOne);

        groceryCatalog.list(availableCategories);

        verify(printStream).println(contains("1. Category One"));
    }

    @Test
    public void shouldListTwoCategoriesWhenThereAreMultipleCategoriesAvailable() {
        availableCategories.put("1", categoryOne);
        availableCategories.put("2", categoryTwo);

        groceryCatalog.list(availableCategories);

        verify(printStream).println(contains("1. Category One\n2. Category Two"));
    }

    @Test
    public void shouldListASingleItemInACategoryWhenOneItemIsAvailable() {
        availableGroceryItems.put("1", itemOne);

        groceryCatalog.listItemsIn("Category One");

        verify(printStream).println(contains("Title | Description | Category One | "));
    }

    @Test
    public void shouldListTwoItemsInACategoryWheMultipleItemsAreAvailable() {
        availableGroceryItems.put("1", itemOne);
        availableGroceryItems.put("2", itemTwo);

        groceryCatalog.listItemsIn("Category One");

        verify(printStream).println("1. Title | Description | Category One | Price\n2. Title Two | Description Two | Category One | Price Two\n");
    }

    @Test
    public void shouldPromptUserToEnterNameOfItemWhenShopIsCalled() {
        groceryCatalog.shop();

        verify(printStream).println(contains("item number that corresponds with the item you would like to add to your basket"));
    }

    @Test
    public void shouldGetSelectedItemFromUserWhenUserHasBeenPrompted() {
        groceryCatalog.shop();

        verify(userInput).getInput();
    }

    @Test
    public void shouldAddItemToBasketWhenItemIsAvailable() {
        when(userInput.getInput()).thenReturn("1");
        availableGroceryItems.put("1", itemOne);

        groceryCatalog.shop();

        verify(basket).add("Title | Description | Category One | Price");
    }

    @Test
    public void shouldRemoveItemFromAvailableItemsWhenAddedToBasket() {
        when(userInput.getInput()).thenReturn("1");
        availableGroceryItems.put("1", itemOne);

        groceryCatalog.shop();

        assertThat(availableGroceryItems.size(), is(0));
    }

    @Test
    public void shouldDisplayMessageIfItemIsNotAnAvailablItem() {
        when(userInput.getInput()).thenReturn("5");
        availableGroceryItems.put("1", itemOne);

        groceryCatalog.shop();

        verify(printStream).println(contains("Item is not available"));
    }

}