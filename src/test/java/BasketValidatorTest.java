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
    private GroceryCatalog groceryCatalog;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        userInput = mock(UserInput.class);
        basket = mock(Basket.class);
        groceryCatalog = mock(GroceryCatalog.class);
        basketValidator = new BasketValidator(printStream, userInput, basket, groceryCatalog);
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
        when(groceryCatalog.findItem("Available Item")).thenReturn(true);

        basketValidator.validate();

        //verify(basket).add(itemToPlaceInBasket);
    }

    @Test
    public void shouldDisplayItemIsNotAvailableMessageWhenItemTitleIsNotInTheAvailableGroceryCatalog() {
        when(userInput.getInput()).thenReturn("Available Item");
        when(groceryCatalog.findItem("Available Item")).thenReturn(false);

        basketValidator.validate();

        verify(printStream).println(contains("Item Title Is Not In Stock"));
    }
}