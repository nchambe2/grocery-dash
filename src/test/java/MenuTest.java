import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;
    private Map<String, Command> groceryCommands;
    private Command browseAvailableItemsCommand;
    private Command browseAvailableCategoriesCommand;
    private Command browseAvailableItemsInACategory;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        browseAvailableItemsCommand = mock(Command.class);
        browseAvailableCategoriesCommand = mock(Command.class);
        browseAvailableItemsInACategory = mock(Command.class);
        groceryCommands = new HashMap<>();
        groceryCommands.put("Browse Available Items", browseAvailableItemsCommand);
        groceryCommands.put("Browse Available Categories", browseAvailableCategoriesCommand);
        groceryCommands.put("Browse Available Items In A Category", browseAvailableItemsInACategory);
        menu = new Menu(printStream, groceryCommands);
    }

    @Test
    public void shouldDisplayBrowseAvailableItemsAsAnOptionWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream, times(2)).println(contains("Browse Available Items"));
    }

    @Test
    public void shouldDisplayBrowseAvailableCategoriesAsAnOptionWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream).println(contains("Browse Available Categories"));
    }

    @Test
    public void shouldDisplayBrowseAvailableItemsInACategoryWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream).println(contains("Browse Available Items In A Category"));
    }

}