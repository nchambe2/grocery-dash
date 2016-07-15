public class RemoveItemFromBasket implements Command {
    private final Shopper shopper;

    public RemoveItemFromBasket(Shopper shopper) {

        this.shopper = shopper;
    }

    @Override
    public void run() {
        shopper.placeItemBackOnShelf();
    }
}
