import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class BasketValidatorTest {

    private PrintStream printStream;
    private UserInput userInput;
    private BasketValidator basketValidator;
    private Basket basket;
    private ItemCatalog itemCatalog;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        basket = mock(Basket.class);
        itemCatalog = mock(ItemCatalog.class);
        basketValidator = new BasketValidator(printStream, userInput, basket, itemCatalog);
    }

    @Test
    public void shouldPromptUserToEnterNameOfItemWhenValidating() {
        basketValidator.validate();

        verify(printStream).println(contains("item you would like to add to your basket"));
    }

    @Test
    public void shouldGetSelectedItemFromUserWhenUserHasBeenPrompted() {
        basketValidator.validate();

        verify(userInput).getInput();
    }

    @Test
    public void shouldAddItemToBasketWhenItemTitleIsInTheAvailableGroceryCatalog() {
        when(userInput.getInput()).thenReturn("Available Item");
        when(itemCatalog.findItem("Available Item")).thenReturn(true);

        basketValidator.validate();

        verify(basket).add();
    }

    @Test
    public void shouldDisplayItemIsNotAvailableMessageWhenItemTitleIsNotInTheAvailableGroceryCatalog() {
        when(userInput.getInput()).thenReturn("Available Item");
        when(itemCatalog.findItem("Available Item")).thenReturn(false);

        basketValidator.validate();

        verify(printStream).println(contains("Item Title Is Not In Stock"));
    }
}