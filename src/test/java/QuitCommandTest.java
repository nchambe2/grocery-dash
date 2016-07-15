import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitCommandTest {
    @Test
    public void shouldDisplayGoodbyeMessageWhenCommandIsCalled() {
        PrintStream printStream = mock(PrintStream.class);
        QuitCommand quitCommand = new QuitCommand(printStream);

        quitCommand.run();

        verify(printStream).println(contains("Goodbye!"));
    }
}