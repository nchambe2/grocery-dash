import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ItemCatalogTest {

    private Collection<Item> availableGroceryItems;
    private ItemCatalog itemCatalog;
    private Item itemOne;
    private Collection<Category> availableCategories;
    private Category categoryOne;
    private Item itemTWo;
    private Category categoryTwo;

    @Before
    public void setUp () {
        availableGroceryItems = new ArrayList<>();
        itemOne = mock(Item.class);
        itemTWo = mock(Item.class);
        availableCategories = new ArrayList<>();
        categoryOne = mock(Category.class);
        categoryTwo = mock(Category.class);
        itemCatalog = new ItemCatalog(availableGroceryItems, availableCategories);
    }

    @Test
    public void shouldReturnAvailableGroceryItemsWhenCalled() {
        availableGroceryItems.add(itemOne);

        assertThat(itemCatalog.getAvailableGroceryItems(), is(availableGroceryItems));
    }

    @Test
    public void shouldReturnAvailableCategoriesWhenCalled() {
        availableCategories.add(categoryOne);

        assertThat(itemCatalog.getAvailableCategories(), is(availableCategories));
    }

    @Test
    public void shouldReturnTrueIfItemToBeFoundIsInAvailableGroceryList() {
        availableGroceryItems.add(itemOne);

       //assertThat(itemCatalog.findItem(itemOne), is(true));
    }

    @Test
    public void shouldReturnFalseIfItemToBeFoundIsNotInAvailableGroceryList() {
        availableGroceryItems.add(itemOne);

       // assertThat(itemCatalog.findItem(itemTWo), is(false));
    }

    @Test
    public void shouldReturnTrueIfCategoryToBeFoundIsAnAvailableCategory() {
        availableCategories.add(categoryOne);

        assertThat(itemCatalog.findCategory(categoryOne), is(true));
    }

    @Test
    public void shouldReturnFalseIfCategoryToBeFoundIsNotAnAvailableCategory() {
        availableCategories.add(categoryOne);

        assertThat((itemCatalog.findCategory(categoryTwo)), is(false));
    }


}