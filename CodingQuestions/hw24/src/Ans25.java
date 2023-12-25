import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Ans25 {
    public static void hw1() throws ExecutionException, InterruptedException {
        int num1=10, num2=15;
        CompletableFuture<Integer> sumFuture=CompletableFuture.supplyAsync(() -> num1+num2);
        CompletableFuture<Integer> productFuture=CompletableFuture.supplyAsync(() -> num1*num2);

        sumFuture.thenCombine(productFuture, (sum,product)-> {
            System.out.println(sum+" "+product);
            return null;
        }).get();
    }

    public static void hw2() throws ExecutionException, InterruptedException{
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

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        for (CompletableFuture<String> future : futures) {
            System.out.println("Response: " + future.get());
        }
    }

    public static void hw3() throws ExecutionException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();

        List<String> apiUrls = List.of(
                "https://jsonplaceholder.typicode.com/posts/-1",
                "https://jsonplaceholder.typicode.com/comments/gf",
                "https://jsonplaceholder.typicode.com/albums/2"
        );

        List<CompletableFuture<String>> futures = apiUrls.stream()
                .map(url -> client.sendAsync(
                                HttpRequest.newBuilder().uri(URI.create(url)).GET().build(),
                                HttpResponse.BodyHandlers.ofString()
                        )
                        .thenApply(HttpResponse::body)
                        .exceptionally(e ->{
                            System.out.println(e.getMessage());
                            return "Default";
                        })
                )

                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        for (CompletableFuture<String> future : futures) {
            System.out.println("Response: " + future.get());
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        hw3();
    }
}
