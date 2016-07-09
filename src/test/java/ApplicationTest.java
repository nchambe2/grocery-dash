import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    private Menu menu;
    private Application application;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        menu = mock(Menu.class);
        bufferedReader = mock(BufferedReader.class);
        application = new Application(menu, bufferedReader);
    }

    @Test
    public void shouldDisplayMenuOptionsWhenApplicationStarts() {
        application.start();

        verify(menu).display();
    }

    @Test
    public void shouldValidateUserMenuOptionSelectionWhenCalled() throws IOException {
        application.start();

        verify(menu).validate(anyString());
    }
}

