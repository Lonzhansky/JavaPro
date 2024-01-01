package lesson17.task2;

import java.util.List;
import java.util.stream.Collectors;

public class PriceFilter implements ProductFilter {
    private double maxPrice;

    public PriceFilter(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Product> filter(List<Product> products) {
        return products.stream()
                .filter(product -> product.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}