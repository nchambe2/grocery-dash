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

    private GroceryCatalog groceryCatalog;
    private BrowseAvailableCategoriesCommand browseAvailableCategoriesCommand;
    private PrintStream printStream;
    private Collection<String> availableCategories;
    private String categoryOne;
    private String categoryTwo;

    @Before
    public void setUp() {
        groceryCatalog = mock(GroceryCatalog.class);
        printStream = mock(PrintStream.class);
        availableCategories = new ArrayList<>();
        categoryOne = "Category One";
        categoryTwo = "Category Two";
        browseAvailableCategoriesCommand = new BrowseAvailableCategoriesCommand(groceryCatalog, printStream);
    }

    @Test
    public void shouldListASingleCategoryWhenThereIsOneAvailableCategory() {
        availableCategories.add(categoryOne);
        when(groceryCatalog.getAvailableCategories()).thenReturn(availableCategories);

        browseAvailableCategoriesCommand.run();

        verify(printStream).println(contains("Category One"));
    }

    @Test
    public void shouldListTwoCategoriesWhenThereAreMultipleeAvailableCategorie() {
        availableCategories.add(categoryOne);
        availableCategories.add(categoryTwo);
        when(groceryCatalog.getAvailableCategories()).thenReturn(availableCategories);
        
        browseAvailableCategoriesCommand.run();

        //verify that you print out all the right things
        verify(printStream).println(contains("Category One\nCategory Two"));
    }

}