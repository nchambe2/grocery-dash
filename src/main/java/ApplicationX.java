public class ApplicationX {
    private final ItemCatalog itemCatalog;

    public ApplicationX(ItemCatalog itemCatalog) {

        this.itemCatalog = itemCatalog;
    }

    public void start() {
        itemCatalog.list();
    }
}
