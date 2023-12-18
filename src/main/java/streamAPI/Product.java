package streamAPI;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Product {
    private static int idCounter = 0;

    private final int id;
    private final String type;
    private final double price;
    private final boolean discount;
    private final LocalDate createDate;

    public Product(String type, double price, boolean discount, LocalDate createDate) {
        this.id = idCounter++;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
    

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }

    // Метод для генерації прикладового списку продуктів
    public static List<Product> createSampleProducts() {
        LocalDate currentDate = LocalDate.now();

        return Arrays.asList(
                new Product("Book", 300.0, false, currentDate.minusDays(5)),
                new Product("Book", 200.0, true, currentDate.minusDays(2)),
                new Product("Toy", 100.0, true, currentDate.minusDays(7)),
                new Product("Book", 150.0, false, currentDate.minusDays(3)),
                new Product("Toy", 120.0, false, currentDate.minusDays(1)),
                new Product("Book", 90.0, true, currentDate.minusDays(6))
        );
    }

    public void setPrice(double v) {
    }
}