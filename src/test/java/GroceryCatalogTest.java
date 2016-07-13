import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GroceryCatalogTest {

    private Collection<Item> availableGroceryItems;
    private GroceryCatalog groceryCatalog;
    private Item itemOne;
    private Collection<String> availableCategories;
    private String categoryOne;
    private Item itemTWo;
    private String categoryTwo;

    @Before
    public void setUp () {
        availableGroceryItems = new ArrayList<>();
        itemOne = mock(Item.class);
        itemTWo = mock(Item.class);
        availableCategories = new ArrayList<>();
        categoryOne = "Category One";
        categoryTwo = "Category Two";
        groceryCatalog = new GroceryCatalog(availableGroceryItems, availableCategories);
    }

    @Test
    public void shouldReturnAvailableGroceryItemsWhenCalled() {
        availableGroceryItems.add(itemOne);

        assertThat(groceryCatalog.getAvailableGroceryItems(), is(availableGroceryItems));
    }

    @Test
    public void shouldReturnAvailableCategoriesWhenCalled() {
        availableCategories.add(categoryOne);

        assertThat(groceryCatalog.getAvailableCategories(), is(availableCategories));
    }

    @Test
    public void shouldReturnTrueWhenItemTitleIsAnAvailableGroceryItem() {
        when(itemOne.details()).thenReturn("Item Title");

        availableGroceryItems.add(itemOne);

       assertThat(groceryCatalog.findItem("Item Title"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenItemTitleIsNotAnAvailableGroceryItem() {
        when(itemOne.details()).thenReturn("Item Title");

        availableGroceryItems.add(itemOne);

       assertThat(groceryCatalog.findItem("Wrong Item Title"), is(false));
    }

    @Test
    public void shouldReturnTrueIfCategoryToBeFoundIsAnAvailableCategory() {
        availableCategories.add(categoryOne);

        assertThat(groceryCatalog.findCategory("Category Title"), is(true));
    }

    @Test
    public void shouldReturnFalseIfCategoryToBeFoundIsNotAnAvailableCategory() {

        availableCategories.add(categoryOne);

        assertThat((groceryCatalog.findCategory("Wrong Category Title")), is(false));
    }


}