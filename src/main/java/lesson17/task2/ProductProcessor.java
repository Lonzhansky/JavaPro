package lesson17.task2;

import java.util.List;

public class ProductProcessor {
    public double calculateTotalPrice(List<Product> products) {
        return products.stream()
                .filter(product -> product.getPrice() >= 0.0)
                .mapToDouble(Product::getPrice)
                .sum();
    }
}