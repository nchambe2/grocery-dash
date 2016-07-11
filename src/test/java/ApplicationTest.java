import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
        application = new Application(menu, menuValidator, userInput, printStream);
    }

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationStarts() {
        application.start();

        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayMenuOptionsWhenApplicationStarts() {
        application.start();

        verify(menu).display();
    }

    @Test
    public void shouldValidateUserMenuOptionSelectionWhenCalled() throws IOException {
        application.start();

        verify(menuValidator).validate(anyString());
    }
}

