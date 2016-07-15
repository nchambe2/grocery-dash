import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuValidatorTest {

    private PrintStream printStream;
    private MenuValidator menuValidator;
    //question about collections
    private Map<String, Command> groceryCommands;
    private Command browseItemsCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        browseItemsCommand = mock(Command.class);
        groceryCommands = new HashMap<>();
        menuValidator = new MenuValidator(printStream, groceryCommands);
    }

    @Test
    public void shouldRunBrowseItemsCommandWhenUserInputMapsToAGroceryCommand() {
        groceryCommands.put("1", browseItemsCommand);

        menuValidator.validate("1");

        verify(browseItemsCommand).run();
    }

    @Test
    public void shouldDisplayInvalidSelectionMessageWhenUserInputIsNotAGroceryCommand() {
        groceryCommands.put("1", browseItemsCommand);

        menuValidator.validate("2");

        verify(printStream).println(contains("Invalid Selection"));
    }

}