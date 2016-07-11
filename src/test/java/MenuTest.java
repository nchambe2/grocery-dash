import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        menu = new Menu(printStream);
    }

    @Test
    public void shouldDisplayBrowseByItemsAsAnOptionWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream).println(contains("Browse Available Items"));
    }

    @Test
    public void shouldDisplayBrowseByCategoryAsAnOptionWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream).println(contains("Browse Available Categories"));
    }

    @Test
    public void shouldDisplayBrowseAvailableItemsInACategoryWhenMenuIsDisplayed() {
        menu.display();

        verify(printStream).println(contains("Browse Available Items In A Category"));
    }

}