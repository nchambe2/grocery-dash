public class AddItemToBasketCommand implements Command{
    private final Basket basket;

    public AddItemToBasketCommand(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.add();
    }
}
