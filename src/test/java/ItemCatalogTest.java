import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ItemCatalogTest {

    private PrintStream printStream;
    private Collection<Item> availableGroceryItems;
    private ItemCatalog itemCatalog;
    private Item itemOne;
    private Item itemTwo;
    private Collection<Category> availableCategories;
    private Category categoryOne;
    private Category categoryTwo;

    @Before
    public void setUp () {
        printStream = mock(PrintStream.class);
        availableGroceryItems = new ArrayList<>();
        itemOne = mock(Item.class);
        itemTwo = mock(Item.class);
        availableCategories = new ArrayList<>();
        categoryOne = mock(Category.class);
        categoryTwo = mock(Category.class);
        itemCatalog = new ItemCatalog(printStream, availableGroceryItems, availableCategories);
    }

    @Test
    public void shouldDisplayASingleGroceryItemWhenThereIsOneAvailableGroceryItemX() {
        availableGroceryItems.add(itemOne);

        itemCatalog.listItems();

        verify(itemOne).details();
    }

    @Test
    public void shouldDisplayTwoGroceryItemsWhenThereAreTwoAvailableGroceryItems() {
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);

        itemCatalog.listItems();

        verify(itemOne).details();
        verify(itemTwo).details();
    }

    @Test
    public void shouldDisplayASingleCategoryWhenThereIsOneAvailableCategory() {
        availableCategories.add(categoryOne);

        itemCatalog.listCategories();

        verify(categoryOne).getTitle();
    }

    @Test
    public void shouldDisplayTwoCategoriesWhenThereAreMultipleAvailableCategories() {
        availableCategories.add(categoryOne);
        availableCategories.add(categoryTwo);

        itemCatalog.listCategories();

        verify(categoryOne).getTitle();
        verify(categoryTwo).getTitle();
    }

}