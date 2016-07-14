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

public class GroceryCatalogTest {

    private Collection<String> availableGroceryItems;
    private GroceryCatalog groceryCatalog;
    private String itemOne;
    private Collection<String> availableCategories;
    private String categoryOne;
    private String itemTwo;
    private String categoryTwo;
    private PrintStream printStream;

    @Before
    public void setUp () {
        availableGroceryItems = new ArrayList<>();
        itemOne = "Title | Description | Category One | Price";
        itemTwo = "Title Two | Description Two | Category One | Price Two";
        availableCategories = new ArrayList<>();
        categoryOne = "Category One";
        categoryTwo = "Category Two";
        printStream = mock(PrintStream.class);
        groceryCatalog = new GroceryCatalog(availableGroceryItems, availableCategories, printStream);
    }

    @Test
    public void shouldReturnTrueWhenItemIsAvailable() {
        availableGroceryItems.add(itemOne);

       assertThat(groceryCatalog.isAvailable(availableGroceryItems, "Title"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotAvailable() {
        availableGroceryItems.add(itemOne);

       assertThat(groceryCatalog.isAvailable(availableGroceryItems, "Wrong Item Title"), is(false));
    }

    @Test
    public void shouldReturnTrueIfCategoryIsAvailable() {
        availableCategories.add(categoryOne);

        assertThat(groceryCatalog.isAvailable(availableCategories, "Category One"), is(true));
    }

    @Test
    public void shouldReturnFalseIfCategoryIsNotAnAvailable() {
        availableCategories.add(categoryOne);

       assertThat((groceryCatalog.isAvailable(availableCategories, "Wrong Category Title")), is(false));
    }

    @Test
    public void shouldListASingleItemWhenOneItemIsAvailable() {
        availableGroceryItems.add(itemOne);

        groceryCatalog.list(availableGroceryItems);

        verify(printStream).println(contains("Title | Description | Category One | Price"));
    }

    @Test
    public void shouldListTwoItemsWhenAreMultipleItemsAvailable() {
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);

        groceryCatalog.list(availableGroceryItems);

        verify(printStream).println(contains("Title | Description | Category One | Price\nTitle Two | Description Two | Category One | Price Two"));
    }

    @Test
    public void shouldListASingleCategoryWhenOneCategoryIsAvailable() {
        availableCategories.add(categoryOne);

        groceryCatalog.list(availableCategories);

        verify(printStream).println(contains("Category One"));
    }

    @Test
    public void shouldListTwoCategoriesWhenThereAreMultipleCategoriesAvailable() {
        availableCategories.add(categoryOne);
        availableCategories.add(categoryTwo);

        groceryCatalog.list(availableCategories);

        verify(printStream).println(contains("Category One\nCategory Two"));
    }

    @Test
    public void shouldListASingleItemInACategoryWhenOneItemIsAvailable() {
        availableGroceryItems.add(itemOne);

        groceryCatalog.listItemsIn("Category One");

        verify(printStream).println(contains("Title | Description | Category One | "));
    }

    @Test
    public void shouldListTwoItemsInACategoryWheMultipleItemsAreAvailable() {
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);

        groceryCatalog.listItemsIn("Category One");

        verify(printStream).println("Title | Description | Category One | Price\nTitle Two | Description Two | Category One | Price Two\n");
    }



}