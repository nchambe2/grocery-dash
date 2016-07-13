import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BrowseAvailableCategoriesCommandTest {

    private ItemCatalog itemCatalog;
    private BrowseAvailableCategoriesCommand browseAvailableCategoriesCommand;
    private PrintStream printStream;
    private Collection<Category> availableCategories;
    private Category categoryOne;
    private Category categoryTwo;

    @Before
    public void setUp() {
        itemCatalog = mock(ItemCatalog.class);
        printStream = mock(PrintStream.class);
        availableCategories = new ArrayList<>();
        categoryOne = mock(Category.class);
        categoryTwo = mock(Category.class);
        browseAvailableCategoriesCommand = new BrowseAvailableCategoriesCommand(itemCatalog, printStream);
    }

    @Test
    public void shouldListASingleCategoryWhenThereIsOneAvailableCategory() {
        availableCategories.add(categoryOne);
        when(categoryOne.getTitle()).thenReturn("Category Title");
        when(itemCatalog.getAvailableCategories()).thenReturn(availableCategories);

        browseAvailableCategoriesCommand.run();

        verify(printStream).println(contains("Category Title"));
    }

    @Test
    public void shouldListTwoCategoriesWhenThereAreMultipleeAvailableCategorie() {
        availableCategories.add(categoryOne);
        availableCategories.add(categoryTwo);
        when(categoryOne.getTitle()).thenReturn("Category Title One");
        when(categoryTwo.getTitle()).thenReturn("Category Title Two");
        when(itemCatalog.getAvailableCategories()).thenReturn(availableCategories);

        browseAvailableCategoriesCommand.run();

        verify(printStream).println(contains("Category Title One"));
        verify(printStream).println(contains("Category Title Two"));
    }

}