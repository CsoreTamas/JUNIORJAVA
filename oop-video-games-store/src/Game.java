public class Game {
    private final String title;
    private final String genre;
    private final double price;
    private boolean inStock;

    public Game(String title, String genre, double price, boolean inStock) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.inStock = inStock;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String toString() {
        return String.format("Title: %s , Genre: %s , Price: %s Forint. , In stock: %s%n", this.title, this.genre, this.price, (this.inStock ? "Yes" : "No"));
        // return "Title: " + this.title + " , Genre: " + this.genre + " , Price: " + this.price + " Forint , In stock: " + (this.inStock ? "Yes" : "No") + "\n";
    }
}
