public class ViewAvailableItemsCommand implements Command{

    private final Inventory inventory;

    public ViewAvailableItemsCommand(Inventory inventory) {

        this.inventory = inventory;
    }

    //just have the catalog list them
    //just move behavior into class
    @Override
    public void run() {
        inventory.list();
    }
}
