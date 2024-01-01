package lesson17.task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamApiProductTest {

    @Test
    public void testPriceFilterWithEmptyList() {
        List<Product> emptyList = Collections.emptyList();

        ProductFilter priceFilter = new PriceFilter(500.0);
        List<Product> filteredProducts = priceFilter.filter(emptyList);

        assertTrue(filteredProducts.isEmpty());
    }

    @Test
    public void testPriceFilterWithZeroMaxPrice() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0),
                new Product("Phone", 500.0),
                new Product("Headphones", 80.0),
                new Product("Tablet", 300.0),
                new Product("Camera", 700.0)
        );

        ProductFilter priceFilter = new PriceFilter(0.0);
        List<Product> filteredProducts = priceFilter.filter(products);

        assertTrue(filteredProducts.isEmpty());
    }

    @Test
    public void testCalculateTotalPriceWithSingleProduct() {
        List<Product> singleProductList = Collections.singletonList(new Product("Laptop", 1200.0));

        ProductProcessor productProcessor = new ProductProcessor();
        double total = productProcessor.calculateTotalPrice(singleProductList);

        assertEquals(1200.0, total, 0.01);
    }

    @Test
    public void testCalculateTotalPriceWithZeroPrice() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 0.0),
                new Product("Phone", 0.0),
                new Product("Headphones", 0.0)
        );

        ProductProcessor productProcessor = new ProductProcessor();
        double total = productProcessor.calculateTotalPrice(products);

        assertEquals(0.0, total, 0.01);
    }

    @Test
    public void testCalculateTotalPriceWithNegativePrice() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0),
                new Product("Phone", 500.0),
                new Product("Headphones", -80.0)
        );

        ProductProcessor productProcessor = new ProductProcessor();
        double total = productProcessor.calculateTotalPrice(products);

        assertEquals(1700.0, total);
    }
}