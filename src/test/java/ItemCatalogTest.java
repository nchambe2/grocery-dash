import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ItemCatalogTest {

    private Collection<Item> availableGroceryItems;
    private ItemCatalog itemCatalog;
    private Item itemOne;
    private Collection<Category> availableCategories;
    private Category categoryOne;

    @Before
    public void setUp () {
        availableGroceryItems = new ArrayList<>();
        itemOne = mock(Item.class);
        availableCategories = new ArrayList<>();
        categoryOne = mock(Category.class);
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

}