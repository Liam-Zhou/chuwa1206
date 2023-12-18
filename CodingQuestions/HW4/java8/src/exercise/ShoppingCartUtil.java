package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class ShoppingCartUtil {


    private static final List<String> ALTERNATIVE_ITEMS = Arrays.asList("Apple", "Orange", "Banana", "Grape");

    public static Optional<String> getFirstItemName(Customer customer) {
        return null;
    }

    public static double getTotalPrice(Optional<Customer> customer) {
        return 0.0;
    }


    public static String getFirstItemNameWithAlternative(Customer customer) {
        return null;
    }



    public static String getFirstItemNameOrThrowException(Customer customer) throws EmptyCartException {
        return null;
    }

    public static void checkItemsInCart(Customer customer) {
        // write you code
    }

    public static void printItemsInCart(Customer customer) {
        // write your code
    }

    public static String getRandomAlternativeItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALTERNATIVE_ITEMS.size());
        return ALTERNATIVE_ITEMS.get(randomIndex);
    }

}
