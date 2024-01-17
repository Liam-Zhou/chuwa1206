package Q25;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertTrue;

public class HW3 {
    public void demo() {
        CompletableFuture<String> productInformation = ApiIntegration.getProductInformation();
        CompletableFuture<String> reviews = ApiIntegration.getReviews();
        CompletableFuture<String> inventory = ApiIntegration.getInventory();

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(productInformation, reviews, inventory);

        // handle exception
        try {
            combinedFuture.get();

            assertTrue(productInformation.isDone());
            assertTrue(reviews.isDone());
            assertTrue(inventory.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

