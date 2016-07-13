public class AddItemToBasketCommand implements Command{
    private final BasketValidator basketValidator;

    public AddItemToBasketCommand(BasketValidator basketValidator) {
        this.basketValidator = basketValidator;
    }

    @Override
    public void run() {
        basketValidator.validate();
    }
}
