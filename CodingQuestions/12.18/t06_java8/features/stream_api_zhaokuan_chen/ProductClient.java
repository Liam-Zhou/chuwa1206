package com.chuwa.tutorial.t06_java8.features.stream_api_zhaokuan_chen;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class ProductClient {
    public static List<Product> productList = Arrays.asList(
            new Product(1, "Product 1", "Electronics", 99.99, 20),
            new Product(2, "Product 2", "Electronics", 199.99, 15),
            new Product(3, "Product 3", "Electronics", 299.99, 5),
            new Product(4, "Product 4", "Clothing", 49.99, 30),
            new Product(5, "Product 5", "Clothing", 29.99, 25),
            new Product(6, "Product 6", "Clothing", 59.99, 10),
            new Product(7, "Product 7", "Kitchen", 89.99, 8),
            new Product(8, "Product 8", "Kitchen", 120.99, 2),
            new Product(9, "Product 9", "Kitchen", 60.99, 15)
    );

    @Test
    public void toList() {
        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getStock() > 10)
                .collect(Collectors.toList());

    }

    @Test
    public void toSet() {
        Set<String> uniqueCategories = productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }

    @Test
    public void joining() {
        String allProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        System.out.println(allProductNames);
        String allProductNamesNewLine = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining("\n"));
        System.out.println(allProductNamesNewLine);
    }

    @Test
    public void counting() {
        Map<String, Long> counts = productList.stream()
                .collect(
                        Collectors.groupingBy(Product::getCategory, Collectors.counting())
                );
        System.out.println(counts);
    }

    @Test
    public void summingInt() {
        int totalStock = productList.stream().mapToInt(Product::getStock).sum();
    }

    @Test
    public void groupingBy() {
        Map<String, Integer> categoryStock = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getStock)));

        Map<String, Double> categoryAveragePrice = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
    }

    @Test
    public void maxBy() {
        Optional<Product> maxPriceProduct = productList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
    }

    @Test
    public void partitioningBy() {
        Map<Boolean, List<Product>> partitionedProducts = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
    }

    @Test
    public void mapping() {
        Set<String> upperCaseNames = productList.stream()
                .map(Product::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    @Test
    public void match() {
        boolean isAnyProductExpensive = productList.stream()
                .anyMatch(product -> product.getPrice() > 250);
        System.out.println("Is there any expensive product? " + isAnyProductExpensive);

        // allMatch example
        boolean areAllProductsInStock = productList.stream()
                .allMatch(product -> product.getStock() > 0);
        System.out.println("Are all products in stock? " + areAllProductsInStock);

        // noneMatch example
        boolean areNoProductsFree = productList.stream()
                .noneMatch(product -> product.getPrice() == 0);
        System.out.println("Are there no free products? " + areNoProductsFree);
    }

    @Test
    public void findFirst() {
        Optional<Product> firstExpensiveProduct = productList.stream()
                .filter(product -> product.getPrice() > 100)
                .findFirst();
        firstExpensiveProduct.ifPresent(product -> System.out.println("First expensive product: " + product.getName()));
    }

    @Test
    public void findAny() {
        Optional<Product> anyLowStockProduct = productList.stream()
                .filter(product -> product.getStock() < 10)
                .findAny();
        anyLowStockProduct.ifPresent(product -> System.out.println("Any low stock product: " + product.getName()));
    }
}
