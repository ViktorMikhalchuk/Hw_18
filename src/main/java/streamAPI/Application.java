package streamAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static streamAPI.Product.createSampleProducts;

public class Application {
    public static void main(String[] args) {
        System.out.println(getExpensiveBooks(createSampleProducts()));
        System.out.println(getDiscountedBooks(createSampleProducts()));
        System.out.println(findCheapestBook(createSampleProducts()));
        System.out.println(getLatestProducts(createSampleProducts(), 3));
        System.out.println(calculateTotalBookCost(createSampleProducts()));
        System.out.println(groupProductsByType(createSampleProducts()));
    }

    // 1.2
    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getType()) && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    // 2.2
    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getType()) && product.hasDiscount())
                .peek(product -> product.setPrice(product.getPrice() * 0.9)) // Застосування знижки 10%
                .collect(Collectors.toList());
    }

    // 3.2
    public static Product findCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getType()))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: Book] не знайдено"));
    }

    // 4.2
    public static List<Product> getLatestProducts(List<Product> products, int count) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    // 5.2
    public static double calculateTotalBookCost(List<Product> products) {
        LocalDate currentDate = LocalDate.now();

        return products.stream()
                .filter(product -> "Book".equals(product.getType()) && product.getPrice() <= 75
                        && product.getCreateDate().getYear() == currentDate.getYear())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // 6.2
    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}