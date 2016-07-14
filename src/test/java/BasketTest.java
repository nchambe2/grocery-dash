import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BasketTest {

    private PrintStream printStream;
    private Basket basket;
    private Collection<String> itemsToBePurchased;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        itemsToBePurchased = new ArrayList<>();
        basket = new Basket(printStream, itemsToBePurchased);
    }

    @Test
    public void shouldDisplayBasketIsEmptyMessageWhenThereAreNoItemsInTheBasket() {
        basket.display();

        verify(printStream).println(contains("basket is empty"));
    }

    @Test
    public void shouldRemoveItemFromAvailableGroceryItemsWhenAddingAnItemToABasket() {
        basket.add("Juice");

        assertThat(itemsToBePurchased.size(), is(1));
    }
}
