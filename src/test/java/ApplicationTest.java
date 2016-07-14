import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    private Menu menu;
    private Application application;
    private MenuValidator menuValidator;
    private PrintStream printStream;
    private UserInput userInput;

    @Before
    public void setUp() {
        menu = mock(Menu.class);
        menuValidator = mock(MenuValidator.class);
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        application = new Application(menu, menuValidator, printStream, userInput);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        when(userInput.getInput()).thenReturn("0");
        application.start();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayMenuOptionsWhenApplicationStarts() {
        when(userInput.getInput()).thenReturn("0");

        application.start();

        verify(menu).display();
    }

    @Test
    public void shouldValidateUserMenuOptionSelectionWhenCalled() {
        when(userInput.getInput()).thenReturn("0");

        application.start();

        verify(menuValidator).validate("0");
    }


    @Test
    public void shouldQuitWhenUserInputIsZero () {
        when(userInput.getInput()).thenReturn("1").thenReturn("0");

        application.start();

        verify(menu, times(2)).display();
    }

}

