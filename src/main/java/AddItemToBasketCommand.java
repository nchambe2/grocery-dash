public class AddItemToBasketCommand implements Command{
    private final Shopper shopper;

    public AddItemToBasketCommand(Shopper shopper) {
        this.shopper = shopper;
    }

    @Override
    public void run() {
        shopper.shop();
    }
}
