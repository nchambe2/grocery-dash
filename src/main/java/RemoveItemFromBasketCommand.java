public class RemoveItemFromBasketCommand implements Command {
    private final Shopper shopper;

    public RemoveItemFromBasketCommand(Shopper shopper) {

        this.shopper = shopper;
    }

    @Override
    public void run() {
        shopper.placeItemBackOnShelf();
    }
}
