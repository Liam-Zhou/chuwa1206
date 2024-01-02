package space.gavinklfong.demo.streamapi;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

@Slf4j
@DataJpaTest
public class StreamAPITestCopy {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
    public void exercise1() {
        List<Product> result = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equals("Books"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(result.size());
    }

    @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
    public void exercise1a() {
    }

    @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
    public void exercise1b() {
    }

    @Test
    @DisplayName("Obtain a list of order with product category = \"Baby\"")
    public void exercise2() {
       List<Order> result = orderRepo.findAll()
               .stream()
               .filter(order ->
               {
                   return order.getProducts()
                           .stream()
                           .anyMatch(p -> p.getCategory().equals("Baby"));
               })
               .collect(Collectors.toList());

    }

    @Test
    @DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
    public void exercise3() {
        List<Product> result = productRepo.findAll().stream()
                .filter(product -> product.getCategory().equals("Toys"))
                .map(product -> product.withPrice(product.getPrice()*0.9))
                .collect(Collectors.toList());
        System.out.println(result.toString());

    }

    @Test
    @DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
    public void exercise4() {
        List<Product> result =  orderRepo.findAll().stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, Month.FEBRUARY, 1))>= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, Month.APRIL, 1)) <= 0)
                .map(order -> order.getProducts())
                .flatMap(orders -> orders.stream())
                .collect(Collectors.toList());

        System.out.println(result.toString());
    }

    @Test
    @DisplayName("Get the 3 cheapest products of \"Books\" category")
    public void exercise5() {
        productRepo.findAll().stream()
                .filter(product -> product.getCategory().equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .collect(Collectors.toList());

    }

    @Test
    @DisplayName("Get the 3 most recent placed order")
    public void exercise6() {
        orderRepo.findAll().stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());

    }

    @Test
    @DisplayName("Get a list of products which was ordered on 15-Mar-2021")
    public void exercise7() {
//        orderRepo.findAll().stream()
//                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021, Month.MARCH, 15)))
//                .flatMap(order -> order.getProducts().stream())
//                .collect(Collectors.toList());

        List<Product> result = orderRepo.findAll()
                .stream()
                .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(o -> System.out.println(o.toString()))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());


        result.forEach(product -> System.out.println(product));
    }

    @Test
    @DisplayName("Calculate the total lump of all orders placed in Feb 2021")
    public void exercise8() {
        orderRepo.findAll().stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1))>=0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 3, 1))< 0)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();

    }

    @Test
    @DisplayName("Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)")
    public void exercise8a() {

        double result = orderRepo.findAll()
                .stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(o -> o.getProducts().stream())
                .map(Product::getPrice)
                .reduce((acc, price)-> acc + price)
                .get();

        log.info("Total lump sum = " + result);
    }

    @Test
    @DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
    public void exercise9() {
       OptionalDouble result = orderRepo.findAll().stream()
               .filter(order -> order.getOrderDate().equals(LocalDate.of(2021,3,15)))
               .mapToDouble(order -> order.getProducts()
                       .stream()
                       .mapToDouble(product -> product.getPrice())
                       .sum()
               ).average();


        System.out.println(result.getAsDouble());
    }

    @Test
    @DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
    public void exercise10() {
        var statistics = productRepo.findAll().stream()
                .filter(product -> product.getCategory().equals("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();

        System.out.println(statistics);
    }

    @Test
    @DisplayName("Obtain a mapping of order id and the order's product count")
    public void exercise11() {
       var result = orderRepo.findAll().stream()
               .collect(
                       Collectors.toMap(
                               order -> order.getId(),
                               order -> order.getProducts().size())
                        );
        System.out.println(result);
    }

    @Test
    @DisplayName("Obtain a data map of customer and list of orders")
    public void exercise12() {
        var result = orderRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        order -> order.getCustomer().getId()
                ));
        System.out.println(result.size());
    }

    @Test
    @DisplayName("Obtain a data map of customer_id and list of order_id(s)")
    public void exercise12a() {
       var result = orderRepo.findAll()
               .stream()
               .collect(
                       Collectors.groupingBy(
                               order -> order.getCustomer().getId(),
                               Collectors.mapping(Order::getId, Collectors.toList())
                       )
               );

        System.out.println(result.toString());
    }

    @Test
    @DisplayName("Obtain a data map with order and its total price")
    public void exercise13() {
        var result = orderRepo.findAll()
                .stream()
                .collect(Collectors.toMap(
                        order -> order.getId(),
                        order -> order.getProducts()
                                .stream()
                                .mapToDouble(Product::getPrice)
                                .sum()

                ));

        System.out.println(result);
    }

    @Test
    @DisplayName("Obtain a data map with order and its total price (using reduce)")
    public void exercise13a() {
        long startTime = System.currentTimeMillis();
        Map<Long, Double> result = orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                Order::getId,
                                order -> order.getProducts().stream()
                                        .reduce(0.0, (acc, product) -> acc + product.getPrice(), Double::sum)
                        ));

        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 13a - execution time: %1$d ms", (endTime - startTime)));
        log.info(result.toString());
    }

    @Test
    @DisplayName("Obtain a data map of product name by category")
    public void exercise14() {
        var result = productRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.mapping(Product::getName, Collectors.toList())
                        )
                );

        System.out.println(result);
    }

    @Test
    @DisplayName("Get the most expensive product per category")
    void exercise15() {
        productRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        )
                );
    }

    @Test
    @DisplayName("Get the most expensive product (by name) per category")
    void exercise15a() {
        long startTime = System.currentTimeMillis();
        Map<String, String> result = productRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)),
                                        optionalProduct -> optionalProduct.map(Product::getName).orElse(null)
                                )
                        ));
        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 15a - execution time: %1$d ms", (endTime - startTime)));
        log.info(result.toString());
    }

}
