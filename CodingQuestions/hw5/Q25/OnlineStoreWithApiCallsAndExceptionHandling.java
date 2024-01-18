import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class OnlineStoreWithApiCallsAndExceptionHandling {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        List<String> apiUrls = List.of(
                "https://jsonplaceholder.typicode.com/posts/1",
                "https://jsonplaceholder.typicode.com/comments/1",
                "https://jsonplaceholder.typicode.com/albums/2"
        );

        List<CompletableFuture<String>> futures = apiUrls.stream()
                .map(url -> client.sendAsync(
                                HttpRequest.newBuilder().uri(URI.create(url)).GET().build(),
                                HttpResponse.BodyHandlers.ofString()
                        )
                        .thenApply(HttpResponse::body)
                        .exceptionally(ex -> {
                            System.out.println("Exception occurred: " + ex.getMessage());
                            return "Default Data"; // Return default data in case of exception
                        }))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allFutures.thenRun(() -> {
            futures.forEach(future -> {
                try {
                    String response = future.get(); // This could throw an ExecutionException
                    System.out.println("Response: " + response);
                } catch (ExecutionException e) {
                    System.out.println("Exception occurred during the computation: " + e.getCause());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
            });
        });

        allFutures.join(); // Wait for all futures to complete
    }
}

