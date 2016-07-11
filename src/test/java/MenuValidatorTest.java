import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class MenuValidatorTest {

    private ItemCatalog itemCatalog;
    private PrintStream printStream;
    private MenuValidator menuValidator;
    private UserInput userInput;
    //question about collections
    private Map<String, Command> groceryCommands;
    private Command browseItemsCommand;

    @Before
    public void setUp() {
        itemCatalog = mock(ItemCatalog.class);
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        browseItemsCommand = mock(Command.class);
        groceryCommands = new HashMap<>();
        menuValidator = new MenuValidator(printStream, userInput, groceryCommands);

    }

    @Test
    public void shouldRunCommandWhenValidGroceryCommand() {
        when(userInput.getInput()).thenReturn("Amazing Command");
        groceryCommands.put("Amazing Command", browseItemsCommand);

        menuValidator.validate();

        verify(browseItemsCommand).run();
    }

    @Test
    public void shouldDisplayInvalidSelectionMessageWhenUserInputIsNotAGroceryCommand() {
        when(userInput.getInput()).thenReturn("Invalid Command");
        groceryCommands.put("Browse Available Items", browseItemsCommand);

        menuValidator.validate();

        verify(printStream).println(contains("Invalid Selection"));
    }

}