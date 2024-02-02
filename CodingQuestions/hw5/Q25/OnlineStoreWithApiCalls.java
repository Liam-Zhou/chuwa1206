import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class OnlineStoreWithApiCalls {
    public static void main(String[] args) throws InterruptedException {
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
                        .thenApply(HttpResponse::body))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.thenRun(() -> {
            futures.forEach(future -> future.thenAccept(response -> System.out.println("Response: " + response)));
        });

        allFutures.join(); // Wait for all futures to complete
    }
}

