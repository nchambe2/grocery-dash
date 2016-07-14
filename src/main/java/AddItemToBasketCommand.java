public class AddItemToBasketCommand implements Command{
    private final GroceryCatalog groceryCatalog;

    public AddItemToBasketCommand(GroceryCatalog groceryCatalog) {
        this.groceryCatalog = groceryCatalog;
    }

    @Override
    public void run() {
        groceryCatalog.shop();
    }
}
