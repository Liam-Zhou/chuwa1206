package hw23.streams;

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
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
public class StreamApiTestPra {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
	public void exercise1() {
		List<Product> result=productRepo.findAll().stream()
				.filter(o->o.getCategory().equals("Books")&&o.getPrice()>100)
				.collect(Collectors.toList());
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
	public void exercise1a() {
		List<Product> result=productRepo.findAll().stream()
				.filter(t->((Predicate<Product>)o->o.getCategory().equals("Books"))
						.and(o->o.getPrice()>100)
						.test(t))
				.collect(Collectors.toList());
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
	public void exercise1b() {
		BiPredicate<Product,String> filter=(p,c)->p.getCategory().equals(c);
		List<Product> result=productRepo.findAll().stream()
				.filter(p-> filter.test(p,"Books")&&p.getPrice()>100)
				.collect(Collectors.toList());
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of order with product category = \"Baby\"")
	public void exercise2() {
		List<Order> result= productRepo.findAll().stream()
				.filter(p -> p.getCategory().equals("Baby"))
				.map(Product::getOrders)
				.flatMap(Collection::stream).distinct().collect(Collectors.toList());
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
	public void exercise3() {
		List<Product> result=productRepo.findAll().stream()
						.filter(p->p.getCategory().equals("Toys"))
								.map(product -> product.withPrice(product.getPrice()*0.9))
										.collect(Collectors.toList());


		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
	public void exercise4() {
		List<Product> result= orderRepo.findAll().stream()
				.filter(o -> o.getCustomer().getTier() == 2)
				.filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)))
				.filter(o -> o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
				.flatMap(o -> o.getProducts().stream()).distinct().collect(Collectors.toList());

		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Get the 3 cheapest products of \"Books\" category")
	public void exercise5() {
		List<Product> result=productRepo.findAll().stream()
				.filter(o->o.getCategory().equals("Books"))
				.sorted(Comparator.comparingDouble(Product::getPrice))
				.limit(3)
				.collect(Collectors.toList());
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Get the 3 most recent placed order")
	public void exercise6() {
		List<Order> result=orderRepo.findAll().stream()
				.sorted(Comparator.comparing(Order::getOrderDate,Comparator.reverseOrder()))
				.limit(3)
				.collect(Collectors.toList());
		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Get a list of products which was ordered on 15-Mar-2021")
	public void exercise7() {
		List<Product> result= orderRepo.findAll().stream()
				.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMap(o -> o.getProducts().stream()).distinct().collect(Collectors.toList());

		result.forEach(p -> log.info(p.toString()));
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021")
	public void exercise8() {
		Double result=orderRepo.findAll().stream()
				.filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)))
				.filter(o -> o.getOrderDate().isBefore(LocalDate.of(2021, 3, 1)))
				.reduce(0.0,(z,o)->z+o.getProducts().stream().reduce(0d,(u,p)->u+p.getPrice(),Double::sum), Double::sum);

		log.info(result.toString());
	}

	@Test
	@DisplayName("Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)")
	public void exercise8a() {
		Double result=orderRepo.findAll().stream()
				.filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)))
				.filter(o -> o.getOrderDate().isBefore(LocalDate.of(2021, 3, 1)))
				.reduce(0.0,(z,o)->z+o.getProducts().stream().reduce(0d,(u,p)->u+p.getPrice(),Double::sum), Double::sum);

		log.info(result.toString());
	}

	@Test
	@DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
	public void exercise9() {
		double result=orderRepo.findAll().stream()
				.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
				.flatMapToDouble(o->o.getProducts().stream().mapToDouble(Product::getPrice))
				.average().orElse(0d);
		log.info(Double.toString(result));
	}

	@Test
	@DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
	public void exercise10() {
		DoubleSummaryStatistics result=productRepo.findAll().stream()
				.filter(o->o.getCategory().equals("Books"))
				.mapToDouble(Product::getPrice)
				.summaryStatistics();
		log.info(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
				result.getCount(), result.getAverage(), result.getMax(), result.getMin(), result.getSum()));

	}

	@Test
	@DisplayName("Obtain a mapping of order id and the order's product count")
	public void exercise11() {
		Map<Long,Integer> result=orderRepo.findAll().stream()
				.collect(Collectors.toMap(Order::getId,o->o.getProducts().size()));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map of customer and list of orders")
	public void exercise12() {
		Map<Customer,List<Order>> result=orderRepo.findAll().stream()
				.collect(Collectors.groupingBy(Order::getCustomer));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map of customer_id and list of order_id(s)")
	public void exercise12a() {
		Map<Long,List<Long>> result=orderRepo.findAll().stream()
				.collect(Collectors.groupingBy(o->o.getCustomer().getId(),
						Collectors.mapping(Order::getId,Collectors.toList())));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price")
	public void exercise13() {
		Map<Order,Double> result=orderRepo.findAll().stream()
				.collect(Collectors.toMap(Function.identity(), o->o.getProducts().stream().mapToDouble(Product::getPrice).sum()));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map with order and its total price (using reduce)")
	public void exercise13a() {
		Map<Order,Double> result=orderRepo.findAll().stream()
				.collect(Collectors.toMap(Function.identity(),
						o->o.getProducts().stream()
								.mapToDouble(Product::getPrice)
								.reduce(0d,Double::sum)));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Obtain a data map of product name by category")
	public void exercise14() {
		Map<String,List<String>> result=productRepo.findAll().stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.mapping(Product::getName,Collectors.toList())));
		log.info(result.toString());
	}

	@Test
	@DisplayName("Get the most expensive product per category")
	void exercise15() {
		Map<String,Optional<Product>> result=productRepo.findAll().stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
		log.info(result.toString());
	}
	
	@Test
	@DisplayName("Get the most expensive product (by name) per category")
	void exercise15a() {
		Map<String,String> result=productRepo.findAll().stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)),
								op->op.map(Product::getName).orElse(null)
						)
						));
		log.info(result.toString());
	}

}
