public class Item {
    private final String title;
    private final String description;
    private final String category;
    private final String price;

    public Item(String title, String description, String category, String price) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String details() {
        return String.join(" | " , title, description, category, price);
    }

}
