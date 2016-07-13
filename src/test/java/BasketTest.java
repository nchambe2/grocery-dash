import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketTest {
    @Test
    public void shouldDisplayBasketIsEmptyMessageWhenThereAreNoItemsInTheBasket() {
        PrintStream printStream = mock(PrintStream.class);
        Basket basket = new Basket(printStream);

        basket.display();

        verify(printStream).println(contains("basket is empty"));
    }
}