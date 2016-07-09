public class Application {
    private final ItemCatalog itemCatalog;

    public Application(ItemCatalog itemCatalog) {

        this.itemCatalog = itemCatalog;
    }

    public void start() {
        itemCatalog.list();
    }
}
