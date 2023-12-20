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
public class StreamApiTestBlank {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll();

		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
	public void exercise1a() {
		Predicate<Product> categoryFilter = product -> product.getCategory().equalsIgnoreCase("Books");
		Predicate<Product> priceFilter = product -> product.getPrice() > 100;

		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll();

		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1a - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
	public void exercise1b() {
		BiPredicate<Product, String> categoryFilter = (product, category) -> product.getCategory().equalsIgnoreCase(category);

		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll();

		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 1b - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of order with product category = \"Baby\"")
	public void exercise2() {
		long startTime = System.currentTimeMillis();
		List<Order> result = orderRepo.findAll();

		long endTime = System.currentTimeMillis();

		log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(o -> log.info(o.toString()));

	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
	public void exercise3() {
		long startTime = System.currentTimeMillis();

		List<Product> result = productRepo.findAll();


		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 3 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(o -> log.info(o.toString()));

	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4() {
		long startTime = System.currentTimeMillis();
		List<Product> result = orderRepo.findAll();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 4 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(o -> log.info(o.toString()));
	}

	@Test
	@DisplayName("Get the 3 cheapest products of \"Books\" category")
	public void exercise5() {
		long startTime = System.currentTimeMillis();
//              Optional<Product> result = productRepo.findAll()
//                              .stream()
//                              .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//                              .sorted(Comparator.comparing(Product::getPrice))
//                              .findFirst();

		Optional<Product> result = Optional.empty();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 5 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.get().toString());

	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6() {
		long startTime = System.currentTimeMillis();
		List<Order> result = orderRepo.findAll();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 6 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(o -> log.info(o.toString()));
	}

	@Test
	@DisplayName("Get a list of products which was ordered on 15-Mar-2021")
	public void exercise7() {
		long startTime = System.currentTimeMillis();
		List<Product> result = productRepo.findAll();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 7 - execution time: %1$d ms", (endTime - startTime)));
		result.forEach(o -> log.info(o.toString()));
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021")
	public void exercise8() {
		long startTime = System.currentTimeMillis();
		double result = 0;

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 8 - execution time: %1$d ms", (endTime - startTime)));
		log.info("Total lump sum = " + result);
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)")
	public void exercise8a() {
		BiFunction<Double, Product, Double> accumulator = (acc, product) -> acc + product.getPrice();

		long startTime = System.currentTimeMillis();
		double result = 0;

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 8a - execution time: %1$d ms", (endTime - startTime)));
		log.info("Total lump sum = " + result);
	}

	@Test
	@DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
	public void exercise9() {
		long startTime = System.currentTimeMillis();
		double result = 0;

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 9 - execution time: %1$d ms", (endTime - startTime)));
		log.info("Average = " + result);
	}

	@Test
	@DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
	public void exercise10() {
		long startTime = System.currentTimeMillis();
		DoubleSummaryStatistics statistics = null;

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 10 - execution time: %1$d ms", (endTime - startTime)));
		log.info(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
				statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));

	}

	@Test
	@DisplayName("Obtain a mapping of order id and the order's product count")
	public void exercise11() {
		long startTime = System.currentTimeMillis();
		Map<Long, Integer>  result = new HashMap<>();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 11 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map of customer and list of orders")
	public void exercise12() {
		long startTime = System.currentTimeMillis();
		Map<Customer, List<Order>> result = new HashMap<>();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 12 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map of customer_id and list of order_id(s)")
	public void exercise12a() {
		long startTime = System.currentTimeMillis();
		HashMap<Long, List<Long>> result = new HashMap<>();
		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 12a - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price")
	public void exercise13() {
		long startTime = System.currentTimeMillis();
		Map<Order, Double> result = new HashMap<>();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 13 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price (using reduce)")
	public void exercise13a() {
		long startTime = System.currentTimeMillis();
		Map<Long, Double> result = new HashMap<>();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 13a - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map of product name by category")
	public void exercise14() {
		long startTime = System.currentTimeMillis();	
		Map<String, List<String>> result = new HashMap<>();


		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 14 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {
		long startTime = System.currentTimeMillis();
		Map<String, Optional<Product>> result = new HashMap<>();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 15 - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
//		result.forEach((k,v) -> {
//			log.info("key=" + k + ", value=" + v.get());
//		});

	}
	
	@Test
	@DisplayName("Get the most expensive product (by name) per category")
	void exercise15a() {
		long startTime = System.currentTimeMillis();
		Map<String, String> result = new HashMap<>();

		long endTime = System.currentTimeMillis();
		log.info(String.format("exercise 15a - execution time: %1$d ms", (endTime - startTime)));
		log.info(result.toString());
	}

}
