import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class OnlineStore {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> product = getProducts().exceptionally(e -> handleException());
        CompletableFuture<String> review = getReviews();
        CompletableFuture<String> inventory = getInventory();

        CompletableFuture<Void> all = CompletableFuture.allOf(product, review, inventory);

    }


    public static CompletableFuture<String> getProducts() throws Exception{
        try{
            return CompletableFuture.supplyAsync(() -> "get product");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static CompletableFuture<String> getReviews() {
        return CompletableFuture.supplyAsync(() -> "get review");
    }

    public static CompletableFuture<String> getInventory() {
        return CompletableFuture.supplyAsync(() -> "get inventory");
    }

    public static String handleException() {
        return "handle exception";
    }

}
