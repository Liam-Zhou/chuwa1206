package space.gavinklfong.demo.streamapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
public class StreamApiTestRewirte {

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
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.filter(p -> p.getPrice() > 100)
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
	public void exercise1a() {
		Predicate<Product> categoryFilter = product -> product.getCategory().equalsIgnoreCase("Books");
		Predicate<Product> priceFilter = product -> product.getPrice() > 100;
		List<Product> result = productRepo.findAll()
				.stream()
				.filter(product -> categoryFilter.and(priceFilter).test(product))
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
	public void exercise1b() {
		BiPredicate<Product, String> categoryFilter = (product, category) -> product.getCategory().equalsIgnoreCase(category);
		List<Product> result = productRepo.findAll()
				.stream()
				.filter(product -> categoryFilter.test(product, "Books") && product.getPrice() > 100)
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Obtain a list of order with product category = \"Baby\"")
	public void exercise2() {
		List<Order> result = orderRepo.findAll()
				.stream()
				.filter(o -> o.getProducts()
						.stream()
						.anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount")
	public void exercise3() {
		List<Product> result = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
				.map(p -> p.withPrice(p.getPrice() * 0.9))
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4() {
		List<Product> result = orderRepo.findAll()
				.stream()
				.filter(o -> o.getCustomer().getTier() == 2)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Get the 3 cheapest products of \"Books\" category")
	public void exercise5() {
		Optional<Product> result = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.min(Comparator.comparing(Product::getPrice));
	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6() {
		List<Order> result = orderRepo.findAll()
				.stream()
				.sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3)
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Get a list of products which was ordered on 15-Mar-2021")
	public void exercise7() {
		List<Product> result = orderRepo.findAll()
				.stream()
				.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMap(o -> o.getProducts().stream())
				.distinct()
				.collect(Collectors.toList());
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021")
	public void exercise8() {
		double result = orderRepo.findAll()
				.stream()
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
				.flatMap(o -> o.getProducts().stream())
				.mapToDouble(Product::getPrice)
				.sum();
	}

	@Test
	@DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
	public void exercise9() {
		double result = orderRepo.findAll()
				.stream()
				.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMap(o -> o.getProducts().stream())
				.mapToDouble(Product::getPrice)
				.average().getAsDouble();
	}

	@Test
	@DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
	public void exercise10() {
		DoubleSummaryStatistics statistics = productRepo.findAll()
				.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.mapToDouble(Product::getPrice)
				.summaryStatistics();
	}

	@Test
	@DisplayName("Obtain a mapping of order id and the order's product count")
	public void exercise11() {
		Map<Long, Integer> result = orderRepo.findAll()
				.stream()
				.collect(Collectors.toMap(Order::getId, order -> order.getProducts().size()));
	}

	@Test
	@DisplayName("Obtain a data map of customer and list of orders")
	public void exercise12() {
		Map<Customer, List<Order>> result = orderRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(Order::getCustomer));
	}

	@Test
	@DisplayName("Obtain a data map of customer_id and list of order_id(s)")
	public void exercise12a() {
		HashMap<Long, List<Long>> result = orderRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(order -> order.getCustomer().getId(),
						HashMap::new,
						Collectors.mapping(Order::getId, Collectors.toList())));
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price")
	public void exercise13() {
		Map<Order, Double> result = orderRepo.findAll()
				.stream()
				.collect(Collectors.toMap(Function.identity(),
						order -> order.getProducts().stream()
								.mapToDouble(Product::getPrice).sum()));
	}

	@Test
	@DisplayName("Obtain a data map of product name by category")
	public void exercise14() {
		Map<String, List<String>> result = productRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.mapping(Product::getName, Collectors.toList())));
	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {
		Map<String, Optional<Product>> result = productRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.maxBy(Comparator.comparing(Product::getPrice))));
	}

	@Test
	@DisplayName("Get the most expensive product (by name) per category")
	void exercise15a() {
		Map<String, String> result = productRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)),
								optionalProduct -> optionalProduct.map(Product::getName).orElse(null)
						)));
	}
}
