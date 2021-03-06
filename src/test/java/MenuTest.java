import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private PrintStream printStream;
    private Menu menu;
    private Map<String, Command> groceryCommands;
    private Command commandOne;
    private Command commandTwo;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        commandOne = mock(Command.class);
        commandTwo = mock(Command.class);
        groceryCommands = new HashMap<>();
        menu = new Menu(printStream, groceryCommands);
    }

    @Test
    public void shouldDisplayCommandOneWhenThereIsOneGroceryCommand() {
        groceryCommands.put("Command One", commandOne);

        menu.display();

        verify(printStream).println(contains("Command One"));
    }

    @Test
    public void shouldDisplayCommandOneAndTwoWhenThereAreMultipleCommands() {
        groceryCommands.put("Command One", commandOne);
        groceryCommands.put("Command Two", commandTwo);

        menu.display();

        verify(printStream).println(contains("Command One\nCommand Two\n"));
    }

}