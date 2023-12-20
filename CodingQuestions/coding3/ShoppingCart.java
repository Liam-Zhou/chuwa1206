import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class ShoppingCartAnswer {

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

public class Customer {
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}

public class EmptyCartException extends RuntimeException {
    public EmptyCartException(String message) {
        super(message);
    }
}

public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class ShoppingCart {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}