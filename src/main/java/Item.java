public class Item {

    private final String title;
    private final String description;
    private final String category;
    private final String price;
    private Integer quantity;

    public Item(String title, String description, String category, String price, Integer quantity) {

        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String details() {
        return String.join(" | ", title, description, category, price, Integer.toString(quantity));
    }

    public String getCategory() {
        return category;
    }

    public void subtractOne() {

    }
}
