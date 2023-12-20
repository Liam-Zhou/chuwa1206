package java8.exercise;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class ShoppingCartUtil {

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
                .orElseGet(ShoppingCartUtil::getRandomAlternativeItem);
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
        Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .ifPresentOrElse(
                        items -> System.out.println(items.isEmpty() ? "购物车为空" : "购物车中有商品"),
                        () -> System.out.println("购物车为空")
                );
    }

    public static void printItemsInCart(Customer customer) {
        Optional.ofNullable(customer)
                .map(Customer::getShoppingCart)
                .map(ShoppingCart::getItems)
                .ifPresent(items -> {
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

    public static void main(String[] args) {

        Customer customer = new Customer();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item("Apple", 1.5));
        customer.setShoppingCart(shoppingCart);

        System.out.println("First Item Name: " + ShoppingCartUtil.getFirstItemName(customer).orElse("No Item"));
        System.out.println("Total Price: " + ShoppingCartUtil.getTotalPrice(Optional.of(customer)));
        System.out.println("First Item Name with Alternative: " + ShoppingCartUtil.getFirstItemNameWithAlternative(customer));

        try {
            System.out.println("First Item Name or Throw Exception: " + ShoppingCartUtil.getFirstItemNameOrThrowException(customer));
        } catch (EmptyCartException e) {
            e.printStackTrace();
        }

        ShoppingCartUtil.checkItemsInCart(customer);
        ShoppingCartUtil.printItemsInCart(customer);
    }
}

