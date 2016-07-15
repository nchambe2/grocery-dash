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
        when(userInput.getInput()).thenReturn("Quit");

        application.start();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayMenuOptionsWhenWelcomeMessageHasPrinted() {
        when(userInput.getInput()).thenReturn("Quit");

        application.start();

        verify(menu).display();
    }

    @Test
    public void shouldGetUserInputWhenMeuHasBeenDisplayed() {
        when(userInput.getInput()).thenReturn("Quit");

        application.start();

        verify(userInput).getInput();
    }

    @Test
    public void shouldValidateMenuOptionUserSelectsWhenCalled() {
        when(userInput.getInput()).thenReturn("Quit");

        application.start();

        verify(menuValidator).validate("Quit");
    }

    @Test
    public void shouldQuitApplicationWhenUserInputIsZero () {
        when(userInput.getInput()).thenReturn("Menu Selection").thenReturn("Quit");

        application.start();

        verify(menu, times(2)).display();
    }

}

