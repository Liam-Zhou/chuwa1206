package Practical_java8;

import java.util.List;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {
/*

        List<Product> result = productRepo.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());

        List<Order> result = orderRepo.findAll()
                .stream()
                .filter(o ->
                        o.getProducts()
                                .stream()
                                .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
                )
                .collect(Collectors.toList());
        List<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
        .map(p -> p.withPrice(p.getPrice() * 0.9))
        .collect(Collectors.toList());

         List<Product> result = orderRepo.findAll()
      .stream()
      .filter(o -> o.getCustomer().getTier() == 2)
      .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
      .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
      .flatMap(o -> o.getProducts().stream())
      .distinct()
      .collect(Collectors.toList());

        Optional<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
        .sorted(Comparator.comparing(Product::getPrice))
        .findFirst();

          List<Order> result = orderRepo.findAll()
        .stream()
        .sorted(Comparator.comparing(Order::getOrderDate).reversed())
        .limit(3)
        .collect(Collectors.toList());

        List<Product> result = orderRepo.findAll()
        .stream()
        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
        .peek(o -> System.out.println(o.toString()))
        .flatMap(o -> o.getProducts().stream())
        .distinct()
        .collect(Collectors.toList());

          Double result = orderRepo.findAll()
        .stream()
        .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
        .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
        .flatMap(o -> o.getProducts().stream())
        .mapToDouble(p -> p.getPrice())
        .sum();

         Double result = orderRepo.findAll()
        .stream()
        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
        .flatMap(o -> o.getProducts().stream())
        .mapToDouble(p -> p.getPrice())
        .average().getAsDouble();
        DoubleSummaryStatistics statistics = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
        .mapToDouble(p -> p.getPrice())
        .summaryStatistics();

  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum())));

    Map<Long, Integer>  result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.toMap(
                order -> order.getId(),
                order -> order.getProducts().size()
                )
            );

      Map<Customer, List<Order>> result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(Order::getCustomer)
            );

         Map<String, List<String>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.mapping(product -> product.getName(), Collectors.toList()))
            );


    Map<String, Optional<Product>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice)))

 */













    }



}
