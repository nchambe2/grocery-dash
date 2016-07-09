public class Application {
    private final ItemCatalog itemCatalog;
    private final MenuX menux;

    public Application(ItemCatalog itemCatalog, MenuX menux) {

        this.itemCatalog = itemCatalog;
        this.menux = menux;
    }

    public void start() {
        itemCatalog.list();
        menux.display();
    }
}
