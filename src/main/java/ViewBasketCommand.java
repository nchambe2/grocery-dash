public class ViewBasketCommand implements Command {
    private final Basket basket;

    public ViewBasketCommand(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.display();
    }
}
