import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
    private UserInput userInput;

    @Before
    public void setUp () {
        printStream = mock(PrintStream.class);
        availableGroceryItems = new ArrayList<>();
        itemOne = mock(Item.class);
        itemTwo = mock(Item.class);
        availableCategories = new ArrayList<>();
        categoryOne = mock(Category.class);
        categoryTwo = mock(Category.class);
        userInput = mock(UserInput.class);
        itemCatalog = new ItemCatalog(printStream, userInput, availableGroceryItems, availableCategories);
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

    @Test
    public void shouldPromptUserToEnterAnAvailableCategoryWhenListingItemsInASpecificCategory() throws IOException {
        when(userInput.getInput()).thenReturn("Category");

        itemCatalog.listItemsInASpecificCategory();

        verify(printStream).println(contains("Enter A Category"));

    }

    @Test
    public void shouldDisplayASingleItemInACategoryWhenThereIsOnlyOneAvailableItemInACategory() throws IOException {
        when(userInput.getInput()).thenReturn("Category");
        when(itemOne.details()).thenReturn("Title | Description | Category | $0.00");
        availableCategories.add(categoryOne);
        availableGroceryItems.add(itemOne);

        itemCatalog.listItemsInASpecificCategory();

        verify(printStream).println(contains("Title | Description"));
    }

    //problematic setup
    @Test
    public void shouldDisplayTwoItemsInACategoryWhenThereIsAreMultiplAvailableItemsInACategory() throws IOException {
        when(userInput.getInput()).thenReturn("Category");
        when(itemOne.details()).thenReturn("Title | Description | Category | $0.00");
        when(itemTwo.details()).thenReturn("Title Two | Description Two | Category Two | $0.00");
        availableCategories.add(categoryOne);
        availableGroceryItems.add(itemOne);
        availableGroceryItems.add(itemTwo);

        itemCatalog.listItemsInASpecificCategory();

        verify(printStream).println(contains("Title Two | Description Two"));
    }

}