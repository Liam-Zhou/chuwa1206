package com.chuwa.tutorial.t06_java8.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ShoppingCartAnswer {

    // 定义一个备选商品列表
    private static final List<String> ALTERNATIVE_ITEMS = Arrays.asList("Apple", "Orange", "Banana", "Grape");
    public static Optional<String> getFirstItemName(Customer customer) {
        return Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .map(items -> items.get(0))
                .map(Item::getName);
    }

    public static double getTotalPrice(Optional<Customer> customer) {
        return customer.map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .map(items -> items.stream().mapToDouble(Item::getPrice).sum())
                .orElse(0.0);
    }

    public static String getFirstItemNameWithAlternative(Customer customer) {
        return Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .map(items -> items.get(0))
                .map(Item::getName)
                .orElseGet(ShoppingCartAnswer::getRandomAlternativeItem);
    }

    public static String getFirstItemNameOrThrowException(Customer customer) throws EmptyCartException {
        return Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .filter(items -> !items.isEmpty())
                .map(items -> items.get(0))
                .map(Item::getName)
                .orElseThrow(() -> new EmptyCartException("购物车为空或不存在"));
    }

    public static void checkItemsInCart(Customer customer) {
        Optional<List<Item>> itemsOptional = Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems);

        if (itemsOptional.isPresent() && !itemsOptional.get().isEmpty()) {
            System.out.println("购物车中有商品");
        } else {
            System.out.println("购物车为空");
        }
    }

    public static void printItemsInCart(Customer customer) {
        Optional<List<Item>> itemsOptional = Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems);

        itemsOptional.ifPresent(items -> {
            if (!items.isEmpty()) {
                System.out.println("购物车中的商品：");
                items.forEach(item -> System.out.println(item.getName()));
            }
        });
    }

    public static String getRandomAlternativeItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALTERNATIVE_ITEMS.size());
        return ALTERNATIVE_ITEMS.get(randomIndex);
    }

}
