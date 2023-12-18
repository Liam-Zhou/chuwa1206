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
import java.util.function.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

@Slf4j
@DataJpaTest
public class StreamApiTestZhaokuanChenSecondTry {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		List<Product> products = productRepo.findAll();
		List<Product> books = products.stream()
				.filter(product -> "Books".equalsIgnoreCase(product.getCategory()) && product.getPrice() > 100)
				.collect(toList());
		for (Product book : books) {
			System.out.println(book);
		}
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
	public void exercise1a() {
		Predicate<Product> isBooks = product -> "Books".equalsIgnoreCase(product.getCategory());
		Predicate<Product> isOver100 = product -> product.getPrice() > 100;
		List<Product> products = productRepo.findAll();
		List<Product> books = products.stream()
				.filter(product -> isBooks.and(isOver100).test(product))
				.collect(toList());
		for (Product book : books) {
			System.out.println(book);
		}
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
	public void exercise1b() {
		BiPredicate<Product, String> categoryFilter = (product, category) -> category.equalsIgnoreCase(product.getCategory());
		List<Product> books = productRepo.findAll().stream()
				.filter(product -> categoryFilter.test(product, "Books") && product.getPrice() > 100)
				.collect(toList());
		for (Product book : books) {
			System.out.println(book);
		}
	}

	@Test
	@DisplayName("Obtain a list of order with product category = \"Baby\"")
	public void exercise2() {
		List<Order> orders = orderRepo.findAll()
				.stream()
				.filter(order ->
						order.getProducts()
								.stream()
						.anyMatch(product -> "Baby".equalsIgnoreCase(product.getCategory()))
				)
				.collect(toList());
		for (Order order : orders) {
			System.out.println(order);
		}
	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
	public void exercise3() {
		List<Product> toys = productRepo.findAll()
				.stream()
				.filter(product -> product.getCategory().equalsIgnoreCase("Toys"))
				.map(product -> product.withPrice(product.getPrice() * 0.9))
				.collect(toList());
		for (Product toy : toys) {
			System.out.println(toy);
		}
	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4() {
		List<Product> products = orderRepo.findAll()
				.stream()
				.filter(order -> order.getCustomer().getTier() == 2)
				.filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)))
				.filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
				.flatMap(order -> order.getProducts().stream())
				.distinct()
				.collect(toList());
		for(Product product : products) {
			System.out.println(product);
		}
	}

	/**
	 * The provided answer seems to be wrong
	 * The provided answer found the cheapest product rather than 3 cheapest.
	 */
	@Test
	@DisplayName("Get the 3 cheapest products of \"Books\" category")
	public void exercise5() {
		List<Product> cheapest3Products = productRepo.findAll()
				.stream()
				.filter(product -> product.getCategory().equalsIgnoreCase("Books"))
				.sorted(Comparator.comparingDouble(Product::getPrice))
				.limit(3)
				.collect(toList());
		for (Product product : cheapest3Products) {
			System.out.println(product);
		}
	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6() {
		List<Order> threeMostRecentOrder = orderRepo.findAll()
				.stream()
				.sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3)
				.collect(toList());
		for (Order order : threeMostRecentOrder) {
			System.out.println(order);
		}
	}

	@Test
	@DisplayName("Get a list of products which was ordered on 15-Mar-2021")
	public void exercise7() {
		List<Product> products = orderRepo.findAll()
				.stream()
				.filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMap(order -> order.getProducts().stream())
				.distinct()
				.collect(toList());
		for (Product product : products) {
			System.out.println(product);
		}
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021")
	public void exercise8() {
		double total = orderRepo.findAll()
				.stream()
				.filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)))
				.filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 3, 1)))
				.flatMap(order -> order.getProducts().stream())
				.mapToDouble(Product::getPrice)
				.sum();
		System.out.println(total);
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)")
	public void exercise8a() {
		BiFunction<Double, Product, Double> accumulator = (acc, product) -> acc + product.getPrice();
		double total = orderRepo.findAll()
				.stream()
				.filter(order -> order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)))
				.filter(order -> order.getOrderDate().isBefore(LocalDate.of(2021, 3, 1)))
				.flatMap(order -> order.getProducts().stream())
				.reduce(0D, accumulator, Double::sum);
		System.out.println(total);
	}

	@Test
	@DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
	public void exercise9() {
		Double avg = orderRepo.findAll()
				.stream()
				.filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMap(order -> order.getProducts().stream())
				.mapToDouble(Product::getPrice)
				.average().orElse(0.0);
		System.out.println(avg);
	}

	@Test
	@DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
	public void exercise10() {
		DoubleSummaryStatistics books = productRepo.findAll()
				.stream()
				.filter(product -> product.getCategory().equalsIgnoreCase("Books"))
				.mapToDouble(Product::getPrice)
				.summaryStatistics();
		System.out.println(books);
	}

	@Test
	@DisplayName("Obtain a mapping of order id and the order's product count")
	public void exercise11() {
		Map<Long, Integer> map = orderRepo.findAll()
				.stream()
				.collect(
						Collectors.toMap(
								Order::getId,
								order -> order.getProducts().size()
						)
				);
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	@DisplayName("Obtain a data map of customer and list of orders")
	public void exercise12() {
		Map<Customer, List<Order>> map = orderRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(Order::getCustomer));
		for (Map.Entry<Customer, List<Order>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	@DisplayName("Obtain a data map of customer_id and list of order_id(s)")
	public void exercise12a() {
		Map<Long, List<Long>> map = orderRepo.findAll()
				.stream()
				.collect(Collectors.groupingBy(
						order -> order.getCustomer().getId(),
						mapping(Order::getId, toList())
				));
		for (Map.Entry<Long, List<Long>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price")
	public void exercise13() {
		Map<Order, Double> map = orderRepo.findAll()
				.stream()
				.collect(
						Collectors.toMap(
								Function.identity(),
								order -> order.getProducts()
										.stream()
										.mapToDouble(Product::getPrice)
										.sum()
						)
				);
		for (Map.Entry<Order, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price (using reduce)")
	public void exercise13a() {
		Map<Order, Double> map = orderRepo.findAll()
				.stream()
				.collect(
						Collectors.toMap(
								Function.identity(),
								order -> order.getProducts()
										.stream()
										.reduce(0.0, (acc, product) -> acc + product.getPrice(), Double::sum)
						)
				);
		for (Map.Entry<Order, Double> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	@DisplayName("Obtain a data map of product name by category")
	public void exercise14() {
		Map<String, List<String>> map = productRepo.findAll()
				.stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory,
								mapping(Product::getName, toList())
						)
				);
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {
		Map<String, Optional<Product>> map = productRepo.findAll()
				.stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory,
								Collectors.maxBy(Comparator.comparing(Product::getPrice))
						)
				);
		for (Map.Entry<String, Optional<Product>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	@Test
	@DisplayName("Get the most expensive product (by name) per category")
	void exercise15a() {
		Map<String, String> map2 = productRepo.findAll()
				.stream()
				.collect(
						Collectors.groupingBy(
								Product::getCategory,
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparing(Product::getPrice)),
										optionalProduct -> optionalProduct.map(Product::getName).orElse(null)
								)

						)
				);
		for (Map.Entry<String, String> entry : map2.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
