import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddItemToBasketCommandTest {

    @Test
    public void shouldValidateItemBeingAdddedToTheBaskedWhenRun() {
        BasketValidator basketValidator = mock(BasketValidator.class);
        AddItemToBasketCommand addItemToBasketCommand = new AddItemToBasketCommand(basketValidator);

        addItemToBasketCommand.run();

        verify(basketValidator).validate();
    }
}